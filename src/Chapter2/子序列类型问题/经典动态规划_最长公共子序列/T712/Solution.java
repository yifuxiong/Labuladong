package Chapter2.子序列类型问题.经典动态规划_最长公共子序列.T712;

// 变换一下思路，最长公共子序列求的是长度，
// 这题可以改成求公共子串的最大ascii码，然后让两个的总和减去两倍的 dp[n][m] 即可

public class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        // dp里面存放的是目前最大公共子序列的ASCII码值
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
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + (int) s1.charAt(i - 1);
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return getASCII(s1) + getASCII(s2) - 2 * dp[m][n];
    }

    public int getASCII(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            ans += (int) s.charAt(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        String s1 = "sea", s2 = "eat";
        String s12 = "delete", s22 = "leet";

        Solution solut = new Solution();
        System.out.println(solut.minimumDeleteSum(s12, s22));
    }
}
