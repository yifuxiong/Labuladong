package 深度优先遍历.T1020;

public class Solution {
    // 上下左右4个方向
    private int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int ans;

    public int numEnclaves(int[][] grid) {
        ans = 0;
        int m = grid.length, n = grid[0].length;
        // 与左右边界相邻的陆地淹没
        for (int i = 0; i < m; i++) {
            dfs(grid, i, 0);
            dfs(grid, i, n - 1);
        }
        // 与上下边界相邻的陆地淹没
        for (int j = 0; j < n; j++) {
            dfs(grid, 0, j);
            dfs(grid, m - 1, j);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public void dfs(int[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return;
        }

        // 原本就是海水
        if (grid[i][j] == 0) {
            return;
        }

        // 陆地填充为海水
        grid[i][j] = 0;
        for (int[] dir : dirs) {
            int nextI = i + dir[0];
            int nextJ = j + dir[1];
            dfs(grid, nextI, nextJ);
        }

        // 离开时操作
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0, 0},
                {1, 0, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0}
        };

        int[][] grid2 = {
                {0, 1, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 0}
        };

        Solution solut = new Solution();
        System.out.println(solut.numEnclaves(grid));
    }
}
