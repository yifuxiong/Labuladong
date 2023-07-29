package Chapter2.用动态规划玩游戏.一个方法团灭LeetCode股票买卖问题.T121;

public class Solution {
    // 动态规划
    // 前i天的最大收益 = max{前i-1天的最大收益，第i天的价格-前i-1天中的最小价格}
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int minVal = 10001;
        int[] dp = new int[n];
        // base case
        dp[0] = 0;

        for (int i = 0; i < n - 1; i++) {
            minVal = Math.min(minVal, prices[i]);
            dp[i + 1] = Math.max(dp[i], prices[i + 1] - minVal);
        }
        return dp[n - 1];
    }

    // 暴力超时
    public int maxProfit2(int[] prices) {
        int n = prices.length;
        int maxVal = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                maxVal = Math.max(maxVal, prices[i] - prices[j]);
            }
        }
        return maxVal;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int[] prices2 = {7, 6, 4, 3, 1};

        Solution solut = new Solution();
        System.out.println(solut.maxProfit(prices));
        System.out.println(solut.maxProfit2(prices));
    }
}
