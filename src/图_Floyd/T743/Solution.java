package 图_Floyd.T743;

public class Solution {
    // 设置为无穷
    int INF = 0x3f3f3f3f;

    // Floyd(邻接矩阵)
    public int networkDelayTime(int[][] times, int n, int k) {
        int[][] weight = new int[n + 1][n + 1];
        // 构建邻接矩阵
        // 根据题意，点的下标是从1到n
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    // 自己到自己的路径长度为0
                    weight[i][j] = 0;
                } else {
                    weight[i][j] = INF;
                }
            }
        }

        // 初始化赋值
        for (int[] t : times) {
            int from = t[0], to = t[1], distance = t[2];
            weight[from][to] = distance;
        }

        // floyd
        // 找中间的一个跳跃点
        for (int p = 1; p <= n; p++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (weight[i][p] + weight[p][j] < weight[i][j]) {
                        weight[i][j] = weight[i][p] + weight[p][j];
                    }
                }
            }
        }

        int ans = 0;
        for (int j = 1; j <= n; j++) {
            ans = Math.max(ans, weight[k][j]);
        }
        // 如果有一个永远达不到，那么返回-1；否则返回ans
        return ans == INF ? -1 : ans;
    }

    public static void main(String[] args) {
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int n = 4, k = 2;

        Solution solut = new Solution();
        System.out.println(solut.networkDelayTime(times, n, k));
    }
}
