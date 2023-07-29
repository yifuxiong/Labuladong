package Chapter2.用动态规划玩游戏.一个方法团灭LeetCode打家劫舍问题.T213;

import java.util.Arrays;

public class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        // base case
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        for (int i = 2; i < n - 1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        int ans = dp[n - 2];

        Arrays.fill(dp, 0);
        dp[0] = nums[1];
        dp[1] = Math.max(dp[0], nums[2]);
        for (int i = 2; i < n; i++) {
            if (i + 1 < n) {
                // dp[2] = Math.max(dp[1], dp[0] + nums[3]);
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i + 1]);
            } else {
                dp[i] = Math.max(dp[i - 1], dp[i - 2]);
            }
        }
        return Math.max(ans, dp[n - 1]);
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 2};
        int[] nums2 = {1, 2, 3, 1};
        int[] nums3 = {1, 2, 3};

        Solution solut = new Solution();
        System.out.println(solut.rob(nums3));
    }
}
