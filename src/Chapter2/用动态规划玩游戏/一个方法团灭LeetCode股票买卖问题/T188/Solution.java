package Chapter2.用动态规划玩游戏.一个方法团灭LeetCode股票买卖问题.T188;

public class Solution {
    public int maxProfit(int _k, int[] prices) {
        int n = prices.length;
        if (n <= 0) {
            return 0;
        }

        if (_k > n / 2) {
            // 复用之前交易次数k没有限制的情况
            return maxProfit_k_inf(prices);
        }

        // base case
        // dp[-1][...][0] = dp[...][0][0] = 0
        // dp[-1][...][1] = dp[...][0][1] = -infinity
        int[][][] dp = new int[n][_k + 1][2];
        // k = 0时的base case
        for (int i = 0; i < n; i++) {
            dp[i][0][1] = Integer.MIN_VALUE;
            dp[i][0][0] = 0;
        }

        for (int i = 0; i < n; i++) {
            for (int k = _k; k >= 1; k--) {
                if (i - 1 == -1) {
                    // 处理i=-1时的base case
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i];
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][_k][0];
    }

    public int maxProfit_k_inf(int[] prices) {
        int n = prices.length;
        // n是第i天，2是持股和卖出两个状态
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i - 1 == -1) {
                // base case
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }

    public static void main(String[] args) {
        int k = 2;
        int[] prices = {2, 4, 1};
        int[] prices2 = {3, 2, 6, 5, 0, 3};

        Solution solut = new Solution();
        System.out.println(solut.maxProfit(k, prices2));


    }
}
