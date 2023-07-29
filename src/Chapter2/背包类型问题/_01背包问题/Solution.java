package Chapter2.背包类型问题._01背包问题;

// 0-1背包问题：这题是求最大价值

public class Solution {
    // 动态规划
    public int knapsack(int W, int N, int[] wt, int[] val) {
        // 前i个物品，当前背包的容量为j
        int[][] dp = new int[N + 1][W + 1];
        // base case
        for (int i = 0; i <= N; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= W; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= W; j++) {
                // 防止越界
                if (j - wt[i - 1] < 0) {
                    // 选不了
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - wt[i - 1]] + val[i - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[N][W];
    }

    private int ans = 0;

    // 递归来做
    public void dfs(int W, int N, int[] wt, int[] val, int curW, int curV, int level) {
        if (level == N) {
            // 遍历完第n-1个物品
            if (curW <= W) {
                ans = Math.max(ans, curV);
            }
            return;
        }
        dfs(W, N, wt, val, curW + wt[level], curV + val[level], level + 1);
        dfs(W, N, wt, val, curW, curV, level + 1);
    }

    public static void main(String[] args) {
        int W = 4, N = 3;
        int[] wt = {2, 1, 3};
        int[] val = {4, 2, 3};

        Solution solut = new Solution();
        System.out.println(solut.knapsack(W, N, wt, val));

        solut.dfs(W, N, wt, val, 0, 0, 0);
        System.out.println(solut.ans);
    }
}
