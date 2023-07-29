package 深度优先遍历.T1254;

public class Solution {
    // 上下左右4个方向
    private int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int ans;

    public int closedIsland(int[][] grid) {
        ans = 0;
        int m = grid.length, n = grid[0].length;

        // 把左右两边的岛屿淹没
        for (int i = 0; i < m; i++) {
            dfs(grid, i, 0);
            dfs(grid, i, n - 1);
        }
        // 把上下两边的岛屿淹没
        for (int j = 0; j < n; j++) {
            dfs(grid, 0, j);
            dfs(grid, m - 1, j);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    ans++;
                    dfs(grid, i, j);
                }
            }
        }
        return ans;
    }

    public void dfs(int[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || i > m - 1 || j < 0 || j > n - 1) {
            return;
        }

        // 0表示陆地，1表示海水
        if (grid[i][j] == 1) {
            return;
        }

        // FloodFill将陆地改为海水
        grid[i][j] = 1;
        for (int[] dir : dirs) {
            int nextI = i + dir[0];
            int nextJ = j + dir[1];
            dfs(grid, nextI, nextJ);
        }

        // 离开时修改
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 1, 1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 1, 0},
                {1, 0, 1, 0, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 0},
        };

        Solution solut = new Solution();
        System.out.println(solut.closedIsland(grid));
    }
}
