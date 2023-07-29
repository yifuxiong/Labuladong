package Chapter2.子序列类型问题.经典动态规划_最长公共子序列.T583;

// DP table先画出来
// 注意：这题只能删除
// 所以这题可以转换思路：找最长公共子序列

public class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

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
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // 这里注意题意：每步只能对一个字符串中的一个字符做处理
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        // word1的长度 - 最长公共子序列长度 + word2的长度 - 最长公共子序列的长度
        // 就是最后作删除操作的步数
        return m + n - 2 * dp[m][n];
    }

    public static void main(String[] args) {
        String word1 = "sea", word2 = "eat";
        String word12 = "leetcode", word22 = "etco";

        Solution solut = new Solution();
        System.out.println(solut.minDistance(word1, word2));
    }
}
