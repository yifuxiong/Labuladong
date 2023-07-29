package 图_Kruskal.T1135;

import java.util.Arrays;

class UnionFind {
    int n;  // 连通分量个数
    int[] parent;  // 存储每个节点的父节点
    int[] size;  // 记录树的“重量”

    public UnionFind(int n) {
        this.n = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    // 合并两个节点
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) {
            return;
        }

        // 小树接到大树下面，较平衡
        if (size[rootX] > size[rootY]) {
            parent[rootY] = rootX;
            size[rootX] += size[rootY];
        } else {
            parent[rootX] = rootY;
            size[rootY] += size[rootX];
        }

        n--;
    }

    // 寻找父节点
    public int find(int x) {
        while (parent[x] != x) {
            // 路径压缩
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    public boolean isConnected(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        return rootX == rootY;
    }

    public int getCount() {
        return n;
    }
}

public class Solution {
    public int minimumCost(int n, int[][] connections) {
        // 城市编号为 1...n，所以初始化大小为 n + 1
        UnionFind uf = new UnionFind(n + 1);
        // 对所有边按照权重从小到大排序
        Arrays.sort(connections, (a, b) -> {
            return a[2] - b[2];
        });

        // 记录最小生成树的权重之和
        int mst = 0;

        for (int[] edge : connections) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];

            // 若这条边会产生环，则不能加入mst
            if (uf.isConnected(u, v)) {
                continue;
            }

            // 若这条边不会产生环，则属于最小生成树
            mst += weight;
            uf.union(u, v);
        }

        // 保证所有节点都被连通
        // 按理说 uf.count() == 1 说明所有节点被连通
        // 但因为节点 0 没有被使用，所以 0 会额外占用一个连通分量

        return uf.getCount() == 2 ? mst : -1;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] connections = {{1, 2, 5}, {1, 3, 6}, {2, 3, 1}};

        Solution solut = new Solution();
        System.out.println(solut.minimumCost(n, connections));
    }
}
