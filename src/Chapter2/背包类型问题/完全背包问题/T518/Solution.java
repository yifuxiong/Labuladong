package Chapter2.背包类型问题.完全背包问题.T518;

// 这题是求有多少种方法

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // 动态规划
    public int change(int amount, int[] coins) {
        int n = coins.length;
        // 使用前i种硬币，当前总额为j，有dp[i][j]种方法可以凑齐
        int[][] dp = new int[n + 1][amount + 1];
        // base case
        for (int i = 0; i <= n; i++) {
            // 总额为0，总有一种选择，那就是不选
            dp[i][0] = 1;
        }
        for (int j = 0; j <= amount; j++) {
            // 没有硬币可以选，那么没有选择
            dp[0][j] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i - 1] < 0) {
                    // 那就不选
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 共有多少种凑法
                    // dp[i][j]应该是两者之和
                    dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j];
                }
            }
        }

        return dp[n][amount];
    }

    private List<String> states = new ArrayList<>();

    // 回溯法
    public void dfs(int amount, int[] coins, int level, int sum, int[] state) {
        if (sum > amount) {
            return;
        }
        if (sum == amount) {
            StringBuffer sb = new StringBuffer();
            for (int s : state) {
                sb.append(s).append('#');
            }
            if (!states.contains(sb.toString())) {
                states.add(sb.toString());
            }
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (i > 0 && coins[i] == coins[i - 1]) {
                continue;
            }

            sum += coins[i];
            state[i]++;
            dfs(amount, coins, level + 1, sum, state);
            state[i]--;
            sum -= coins[i];
        }
    }

    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1, 2, 5};

        Solution solut = new Solution();
        System.out.println(solut.change(amount, coins));

        int[] state = new int[3];
        solut.dfs(amount, coins, 0, 0, state);
        System.out.println(solut.states);
    }
}
