package 并查集.T990;

class UnionFind {
    private int count;
    private int[] parent;
    private int[] size;

    public UnionFind(int n) {
        count = n;
        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        if (rootP == rootQ) {
            return;
        }

        if (size[rootP] > size[rootQ]) {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        } else {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }

        // 连通数-1
        count--;
    }

    public int find(int x) {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    public boolean connected(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        return rootP == rootQ;
    }

    public int getCount() {
        return count;
    }
}

public class Solution {
    public boolean equationsPossible(String[] equations) {
        UnionFind uf = new UnionFind(26);
        for (String eq : equations) {
            if (eq.charAt(1) == '=') {
                uf.union(eq.charAt(0) - 'a', eq.charAt(3) - 'a');
            }
        }

        // 第二遍，检测 != 是否破坏了连通性
        for (String eq : equations) {
            if (eq.charAt(1) == '!') {
                if (uf.connected(eq.charAt(0) - 'a', eq.charAt(3) - 'a')) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String[] equations = {"a==b", "b!=a"};  // false
        String[] equations2 = {"b==a", "a==b"};  // true
        String[] equations3 = {"a==b", "b==c", "a==c"};  // true
        String[] equations4 = {"a==b", "b!=c", "c==a"};  // false
        String[] equations5 = {"c==c", "b==d", "x!=z"};  // true

        Solution solut = new Solution();
        System.out.println(solut.equationsPossible(equations5));
    }
}
