package Chapter2.子序列类型问题.动态规划之子序列问题解题模板.T516;

// 子序列问题，最大...绝对是动态规划
// db table画出来吧

public class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        // dp[i][j]表示的是index从i到j之间的最长回文串子串
        int[][] dp = new int[n][n];
        // base case
        for (int i = 0; i < n; i++) {
            // 只有一个字符，当然是回文串
            dp[i][i] = 1;
            // i > j 或者 i < j 初始都为0
        }

        // 遍历顺序有点难搞
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        String s = "bbbab";
        String s2 = "cbbd";

        Solution solut = new Solution();
        System.out.println(solut.longestPalindromeSubseq(s));
    }
}
