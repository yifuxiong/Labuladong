package 深度优先遍历.T694;

import java.util.HashSet;

public class Solution {
    public int numDistinctIslands(int[][] grid) {
        HashSet<String> islands = new HashSet<>();
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    StringBuffer sb = new StringBuffer();
                    dfs(grid, i, j, 0, sb);
                    islands.add(sb.toString());
                }
            }
        }
        return islands.size();
    }

    // 类似回溯法
    public void dfs(int[][] grid, int i, int j, int dir, StringBuffer sb) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return;
        }

        if (grid[i][j] == 0) {
            return;
        }

        grid[i][j] = 0;

        // sb操作
        sb.append(dir).append(',');

        // 上
        dfs(grid, i - 1, j, 1, sb);
        // 下
        dfs(grid, i + 1, j, 2, sb);
        // 左
        dfs(grid, i, j - 1, 3, sb);
        // 右
        dfs(grid, i, j + 1, 4, sb);

        // 撤销sb操作
        sb.append(-dir).append(',');
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 0, 1, 1},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1},
                {1, 1, 0, 1, 1}
        };

        Solution solut = new Solution();
        System.out.println(solut.numDistinctIslands(grid));
    }
}
