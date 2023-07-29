package Chapter2.用动态规划玩游戏.地下城与勇士;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    // 动态规划，从终点往起点遍历
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        int[][] dp = new int[m][n];
        // base case
        dp[m - 1][n - 1] = Math.max(1, 1 - dungeon[m - 1][n - 1]);

        for (int i = m - 2; i >= 0; i--) {
            dp[i][n - 1] = Math.max(1, dp[i + 1][n - 1] - dungeon[i][n - 1]);
        }
        for (int j = n - 2; j >= 0; j--) {
            dp[m - 1][j] = Math.max(1, dp[m - 1][j + 1] - dungeon[m - 1][j]);
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = Math.max(1, Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j]);
            }
        }
        return dp[0][0];
    }


    int[][] dirs = {{1, 0}, {0, 1}};
    List<Integer> list = new ArrayList<>();

    // dfs
    public int calculateMinimumHP2(int[][] dungeon) {
        dfs(dungeon, 0, 0, dungeon[0][0], 0);
        // System.out.println(list);
        int minimum = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > minimum) {
                minimum = list.get(i);
            }
        }
        if (minimum < 0) {
            return 1 - minimum;
        } else {
            return 1;
        }
    }

    public void dfs(int[][] dungeon, int x, int y, int minVal, int lastVal) {
        int m = dungeon.length, n = dungeon[0].length;

        lastVal += dungeon[x][y];
        if (lastVal < minVal) {
            minVal = lastVal;
        }

        // 结束条件
        if (x == m - 1 && y == n - 1) {
            list.add(minVal);
            return;
        }

        for (int[] dir : dirs) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];

            if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n) {
                return;
            }
            dfs(dungeon, nextX, nextY, minVal, lastVal);
        }
    }

    public static void main(String[] args) {
        int[][] dungeon = {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};

        Solution solut = new Solution();
        System.out.println(solut.calculateMinimumHP(dungeon));
        System.out.println(solut.calculateMinimumHP2(dungeon));
    }
}
