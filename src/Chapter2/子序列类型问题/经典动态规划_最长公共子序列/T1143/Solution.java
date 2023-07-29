package Chapter2.子序列类型问题.经典动态规划_最长公共子序列.T1143;

// 碰到最长子序列问题
// 二维动态规划，DP table写出来

public class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m + 1][n + 1];
        // base case
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(Math.max(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                }
            }
        }

//        for (int i = 0; i <= m; i++) {
//            for (int j = 0; j <= n; j++) {
//                System.out.print(dp[i][j] + ", ");
//            }
//            System.out.println();
//        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        String text1 = "abcde", text2 = "ace";
        String text12 = "abc", text22 = "abc";
        String text13 = "abc", text23 = "def";

        Solution solut = new Solution();
        System.out.println(solut.longestCommonSubsequence(text13, text23));
    }
}
