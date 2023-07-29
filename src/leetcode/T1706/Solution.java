package leetcode.T1706;

import java.util.Arrays;

public class Solution {
    public int[] findBall(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        if (n == 1) {
            // 如果只有1列，那么一定会卡死
            return new int[]{-1};
        }

        int[][] dp = new int[m + 1][n];
        // base case
        // 第0行是球的初始位置
        for (int j = 0; j < n; j++) {
            dp[0][j] = j;
        }
        // 从第一行开始
        for (int i = 1; i <= m; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    // 看有没有从右上角来的
                    if (grid[i - 1][j] == -1 && grid[i - 1][j + 1] == -1) {
                        dp[i][j] = dp[i - 1][j + 1];
                    }
                } else if (j == n - 1) {
                    // 看有没有从左上角来的
                    if (grid[i - 1][j] == 1 && grid[i - 1][j - 1] == 1) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                } else {
                    if (grid[i - 1][j] == 1 && grid[i - 1][j - 1] == 1) {
                        // 从左上角来的
                        dp[i][j] = dp[i - 1][j - 1];
                    } else if (grid[i - 1][j] == -1 && grid[i - 1][j + 1] == -1) {
                        // 从右上角来的
                        dp[i][j] = dp[i - 1][j + 1];
                    }
                }
            }
        }

//        for (int i = 0; i <= m; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(dp[i][j] + ", ");
//            }
//            System.out.println();
//        }
//        System.out.println();

        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        for (int i = 0; i < n; i++) {
            if (dp[m][i] != -1) {
                ans[dp[m][i]] = i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 1, -1, -1}, {1, 1, 1, -1, -1}, {-1, -1, -1, 1, 1}, {1, 1, 1, 1, -1}, {-1, -1, -1, -1, -1}};
        int[][] grid2 = {{-1}};
        int[][] grid3 = {{1, 1, 1, 1, 1, 1}, {-1, -1, -1, -1, -1, -1}, {1, 1, 1, 1, 1, 1}, {-1, -1, -1, -1, -1, -1}};

        Solution solut = new Solution();
        int[] ans = solut.findBall(grid2);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + ", ");
        }
        System.out.println();
    }
}
