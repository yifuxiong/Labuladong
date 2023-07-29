package Chapter2.用动态规划玩游戏.动态规划之最小路径和.T64;

public class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int[][] dp = new int[m][n];
        // base case
        for (int i = 0; i < m; i++) {
            dp[i][0] = grid[i][0];
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = grid[0][j];
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                } else if (i == 0 && j != 0) {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                } else if (i != 0 && j == 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };

        int[][] grid2 = {
                {1, 2, 3},
                {4, 5, 6}
        };

        Solution solut = new Solution();
        System.out.println(solut.minPathSum(grid));
    }
}
