package kwq.类似青蛙过河;

public class Solution {
    public int func(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        // base case;
        dp[0] = nums[0];

        for (int i = 1; i < n; i++) {
            // 前k步中找最大的
            for (int j = i - 1; j >= i - k; j--) {
                if (j >= 0){
                    dp[i] = Math.max(dp[i], dp[j] + nums[i]);
                }
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[] nums = {1, -1, 2, -4, 3, -1, 2};
        int k = 3;

        Solution solut = new Solution();
        System.out.println(solut.func(nums, k));
    }
}
