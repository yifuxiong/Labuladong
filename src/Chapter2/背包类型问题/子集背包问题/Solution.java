package Chapter2.背包类型问题.子集背包问题;

import java.util.Arrays;

public class Solution {
    // 动态规划
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }
        // 使用前i个物品，把容量为sum/2的背包装满
        boolean[][] dp = new boolean[n + 1][sum / 2 + 1];
        // base case
        // 一个物品都没有，肯定装不满
        for (int j = 0; j <= sum / 2; j++) {
            dp[0][j] = false;
        }
        // 有i个物品，容量为0，肯定可以装满
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum / 2; j++) {
                if (j - nums[i - 1] < 0) {
                    // 不选
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }

        return dp[n][sum / 2];
    }

    // 递归
    public boolean dfs(int[] nums, int w1, int w2, int pos) {
        if (pos == nums.length) {
            if (w1 == w2) {
                return true;
            } else {
                return false;
            }
        }
        boolean a = dfs(nums, w1 + nums[pos], w2, pos + 1);
        boolean b = dfs(nums, w1, w2 + nums[pos], pos + 1);
        return a || b;
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};  // true
        int[] nums2 = {1, 2, 3, 5};  // false

        Solution solut = new Solution();
        System.out.println(solut.canPartition(nums));
        System.out.println(solut.dfs(nums, 0, 0, 0));
    }
}
