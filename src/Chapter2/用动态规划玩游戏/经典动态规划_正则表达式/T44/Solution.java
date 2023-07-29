package Chapter2.用动态规划玩游戏.经典动态规划_正则表达式.T44;

class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        // base case
        dp[0][0] = true;
        // for (int i = 1; i <= m; i++){
        //     // 默认情况
        //     dp[i][0] = false;
        // }
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = true;
            } else {
                // 中间有一个不是'*'，后面全为false
                break;
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    // 使用或者不使用这个'*'号
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String s = "aa", p = "*";
        String s2 = "cb", p2 = "?a";

        Solution solut = new Solution();
        System.out.println(solut.isMatch(s, p));
    }
}
