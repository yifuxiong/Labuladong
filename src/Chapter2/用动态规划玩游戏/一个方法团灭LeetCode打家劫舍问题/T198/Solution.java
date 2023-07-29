package Chapter2.用动态规划玩游戏.一个方法团灭LeetCode打家劫舍问题.T198;

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
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[] nums0 = {1};
        int[] nums = {1, 2, 3, 1};  // 4
        int[] nums2 = {2, 7, 9, 3, 1};  // 12

        Solution solut = new Solution();
        System.out.println(solut.rob(nums0));
    }
}
