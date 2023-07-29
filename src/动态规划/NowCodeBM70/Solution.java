package 动态规划.NowCodeBM70;

// 兑换零钱：求组成aim的最少货币数【求最少硬币个数】
// https://www.nowcoder.com/practice/3911a20b3f8743058214ceaa099eeb45?tpId=295&tqId=988994&ru=/exam/oj&qru=/ta/format-top101/question-ranking&sourceUrl=%2Fexam%2Foj

import java.util.Arrays;

public class Solution {
    public int minMoney(int[] arr, int aim) {
        // write code here
        int n = arr.length;
        int[] dp = new int[aim + 1];
        // base case
        Arrays.fill(dp, aim + 1);
        dp[0] = 0;

        for (int i = 1; i <= aim; i++) {
            for (int j = 0; j < n; j++) {
                if (i - arr[j] >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - arr[j]] + 1);
                }
            }
        }
        if (dp[aim] > aim) {
            return -1;
        } else {
            return dp[aim];
        }
    }
}
