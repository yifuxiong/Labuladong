package 图_Kruskal.T1584;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class UF {
    int count;  // 连通分量数量
    int[] parent;  // 各个节点的父节点
    int[] size;  // 每个节点上重量

    public UF(int n) {
        count = n;
        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    // 查找当前节点的父节点
    public int find(int x) {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) {
            return;
        }

        if (size[rootX] > size[rootY]) {
            parent[rootY] = rootX;
            size[rootX] += size[rootY];
        } else {
            parent[rootX] = rootY;
            size[rootY] += size[rootX];
        }

        count--;
    }

    public boolean isConnected(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        return rootX == rootY;
    }

    public int getCount() {
        return count;
    }
}

public class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<int[]> edges = buildEdges(points);
        // 对权重有小到大排序
        Collections.sort(edges, (a, b) -> {
            return a[2] - b[2];
        });

        UF uf = new UF(n);

        // 连接所有点的权重之和
        int mst = 0;
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];

            if (uf.isConnected(u, v)) {
                continue;
            }

            mst += weight;
            uf.union(u, v);
        }

        return uf.count == 1 ? mst : -1;
    }

    public List<int[]> buildEdges(int[][] points) {
        int n = points.length;
        List<int[]> edges = new LinkedList<>();

        // 建立两个点之间的关系
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];

                edges.add(new int[]{i, j, Math.abs(x1 - x2) + Math.abs(y1 - y2)});
            }
        }

        return edges;
    }

    public static void main(String[] args) {
        int[][] points = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};

        Solution solut = new Solution();
        System.out.println(solut.minCostConnectPoints(points));
    }
}
