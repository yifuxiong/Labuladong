package 并查集.T323;

class UnionFind {
    // 连通分量个数
    private int count;
    // 存储每个节点的父节点
    private int[] parent;
    // 新增一个数组记录树的“重量”
    private int[] size;

    public UnionFind(int n) {
        count = n;
        parent = new int[n];
        // 最初每棵树只有一个节点
        // 重量应该初始化 1
        size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    // 将节点p和节点q相通
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        if (rootP == rootQ) {
            return;
        }

        // parent[rootQ] = rootP;
        // 小树接到大树下面，较平衡
        if (size[rootP] > size[rootQ]) {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        } else {
            parent[rootP] = parent[rootQ];
            size[rootQ] += size[rootP];
        }

        // 两个连通分量合并成一个连通分量
        count--;
    }

    // 返回节点x的连通分量根节点
    public int find(int x) {
        while (parent[x] != x) {
            // 进行路径压缩
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    // 判断节点p和节点q是否连通
    public boolean connected(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        return rootP == rootQ;
    }

    // 返回图中的连通分量个数
    public int count() {
        return count;
    }
}


// 给你输入一个包含 n 个节点的图，用一个整数 n 和一个数组 edges 表示，
// 其中 edges[i] = [ai, bi] 表示图中节点 ai 和 bi 之间有一条边。
// 请你计算这幅图的连通分量个数。
public class Solution {
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }
        return uf.count();
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] edges = {{0, 2}, {1, 3}, {0, 3}};

        Solution solut = new Solution();
        System.out.println(solut.countComponents(n, edges));
    }
}
