package Chapter2.子序列类型问题.动态规划设计_最大子数组.T53;

public class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        // base case
        dp[0] = nums[0];

        for (int i = 1; i < n; i++){
            // 选择与前面的dp[i-1]连成一个子序列
            // 选择与前面的dp[i-1]断开，自成一派
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }

        int ans = -10001;
        for (int i = 0; i < n; i++){
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] nums2 = {1};
        int[] nums3 = {5, 4, -1, 7, 8};

        Solution solut = new Solution();
        System.out.println(solut.maxSubArray(nums3));
    }
}
