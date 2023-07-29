package 回文串.T516;

// 这题和NowCodeBM73不同
// 这题在找子串的过程中可以删除或者不删除某些字符
// 而NowCodeBM73必须要找连续的回文子串

public class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            char ch1 = s.charAt(i);
            for (int j = i + 1; j < n; j++) {
                char ch2 = s.charAt(j);
                if (ch1 == ch2) {
                    dp[i][j] = dp[i - 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j + 1], dp[i - 1][j]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
