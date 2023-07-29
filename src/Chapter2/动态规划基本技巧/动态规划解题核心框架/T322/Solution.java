package Chapter2.动态规划基本技巧.动态规划解题核心框架.T322;

import java.util.Arrays;

public class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        // base case
        dp[0] = 0;

        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j >= coins[i]) {
                    dp[j] = Math.min(dp[j], 1 + dp[j - coins[i]]);
                }
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    public int coinChange2(int[] coins, int amount) {
        int res = Integer.MAX_VALUE;

        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }

        for (int i = 0; i < coins.length; i++) {
            int sub = coinChange2(coins, amount - coins[i]);
            if (sub == -1) {
                continue;
            }
            res = Math.min(res, 1 + sub);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;

        int[] coins2 = {2};
        int amount2 = 3;

        int[] coins3 = {1};
        int amount3 = 0;

        Solution solut = new Solution();
        System.out.println(solut.coinChange(coins, amount));
        System.out.println(solut.coinChange2(coins, amount));
    }
}
