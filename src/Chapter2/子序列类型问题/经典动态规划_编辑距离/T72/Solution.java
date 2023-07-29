package Chapter2.子序列类型问题.经典动态规划_编辑距离.T72;

// 大厂经典笔试题
// 最小编辑距离（动态规划）
// 一般处理字符串的动态规划问题，都是按照文本的处理思路，建立DP table。


public class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];
        // base case
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        String word1 = "horse", word2 = "ros";
        String word12 = "intention", word22 = "execution";

        Solution solut = new Solution();
        System.out.println(solut.minDistance(word12, word22));
    }
}
