package Chapter2.动态规划基本技巧.base_case和备忘录的初始值怎么定.T931;

import java.util.Arrays;

public class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        if (n == 1) {
            int sum = 0;
            for (int i = 0; i < m; i++) {
                sum += matrix[i][0];
            }
            return sum;
        }

        int[][] dp = new int[m][n];
        // base case
        // dp第一行的值等于matrix第一行的值
        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j];
        }
        // dp从第二行开始后面的值全部初始化为MAX_VALUE
        for (int i = 1; i < m; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    dp[i + 1][j] = Math.min(dp[i][j], dp[i][j + 1]) + matrix[i + 1][j];
                } else if (j == n - 1) {
                    dp[i + 1][j] = Math.min(dp[i][j - 1], dp[i][j]) + matrix[i + 1][j];
                } else {
                    dp[i + 1][j] = Math.min(Math.min(dp[i][j - 1], dp[i][j]), dp[i][j + 1]) + matrix[i + 1][j];
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            res = Math.min(res, dp[m - 1][j]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{2, 1, 3}, {6, 5, 4}, {7, 8, 9}};
        int[][] matrix2 = {{-19, 57}, {-40, -5}};

        Solution solut = new Solution();
        System.out.println(solut.minFallingPathSum(matrix2));
    }
}
