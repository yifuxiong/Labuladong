package 记忆化搜索.T805;

import java.util.*;

// 这题比较特殊，用记忆化搜索很难写
// 因为记忆化搜索保存的中间情况，一般是递归到中间某个情况时，已经可以确定该情况的值
// 但是本题，在没有遍历完整个数组时，是判断不了当前情况的
// 所以本题用记忆化搜索不能完全解决
// 还是老老实实用动态规划
class Solution {
    Map<String, Boolean> table = new HashMap<>();

    public boolean splitArraySameAverage(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        boolean ans = false;
        for (int i = 1; i <= n / 2; i++) {
            if (sum * i % n == 0) {
                ans = true;
                break;
            }
        }
        if (!ans) {
            return ans;
        }

        return dfs(nums, 0, 0, 0, sum);
    }

    public boolean dfs(int[] nums, int len, int idx, int curSum, int totalSum) {
        if (len >= nums.length) {
            return false;
        }
        if (idx >= nums.length) {
            return false;
        }

        StringBuffer sb = new StringBuffer();
        sb.append(len);
        sb.append('#');
        sb.append(idx);
        sb.append('#');
        sb.append(curSum);
        String key = sb.toString();
        if (table.containsKey(key)) {
            return table.get(key);
        }

        if (len != 0 && nums.length - len != 0) {
            double a1 = (double) curSum / len;
            double a2 = (double) (totalSum - curSum) / (nums.length - len);
            if (a1 == a2) {
                table.put(key, true);
                return true;
            }
        }

        // 选或者不选
        boolean res1 = dfs(nums, len, idx + 1, curSum, totalSum);
        boolean res2 = dfs(nums, len + 1, idx + 1, curSum + nums[idx], totalSum);
        table.put(key, res1 || res2);
        return res1 || res2;
    }


    // 官方题解：动态规划
    public boolean splitArraySameAverage2(int[] nums) {
        if (nums.length == 1){
            return false;
        }

        int n = nums.length;
        int m = n/ 2;
        int sum = 0;
        for (int num: nums){
            sum += num;
        }

        // 必要条件
        boolean isPossible = false;
        for (int i = 1; i <= m; i++){
            // 必须能整除，否则不谈
            if (sum * i % n == 0){
                isPossible = true;
                break;
            }
        }

        if (!isPossible){
            return false;
        }

        Set<Integer>[] dp = new Set[m + 1];
        for (int i = 0; i <= m; i++){
            dp[i] = new HashSet<Integer>();
        }

        dp[0].add(0);
        for (int num: nums){
            for (int i = m; i >= 1; i--){
                for (int x: dp[i - 1]){
                    int curr = x + num;
                    if (curr * n == sum * i){
                        return true;
                    }
                    dp[i].add(curr);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] nums2 = {3, 1};
        int[] nums3 = {10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 2000, 2000, 2000, 2000, 17, 17, 234, 234, 999, 999, 999, 999, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456};
        int[] nums4 = {12, 1, 17, 8, 2};
        int[] nums5 = {41, 8467, 6334, 6500, 9169, 5724, 1478, 9358, 6962, 4464, 5705, 8145, 3281, 6827, 9961, 491, 2995, 1942, 4827, 5436, 2391, 4604, 3902, 153, 292, 2382, 7421, 8716, 9718, 9895};

        Solution solut = new Solution();
        // System.out.println(solut.splitArraySameAverage(nums5));
        System.out.println(solut.splitArraySameAverage2(nums5));
    }
}
