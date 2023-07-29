package fwf.九的倍数;

public class Solution {
    int MOD = 1000000007;

    public int function(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][9];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 9; j++) {
                dp[i][j] = dp[i - 1][(j + 9 - nums[i - 1]) % 9] + dp[i - 1][j];
            }
            dp[i][nums[i - 1] % 9]++;
        }
        return dp[n][0];
    }

    public static void main(String[] args) {
        int[] nums = {1, 8, 9};
        int[] nums2 = {1, 2, 3, 4, 5, 6, 7, 8, 9};  // 200000

        Solution solut = new Solution();
        System.out.println(solut.function(nums));
    }
}
