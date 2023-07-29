package 深度优先遍历.T200;

public class Solution {
    // 上下左右4个方向
    private int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int ans;

    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    ans++;
                    // 每次遇到陆地，就增加一个岛屿
                    dfs(grid, 0, 0);
                }
            }
        }
        return ans;
    }

    public void dfs(char[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return;
        }

        if (grid[i][j] == '0') {
            // 遍历到海水
            return;
        }

        // 用FloodFill，将陆地变成海水
        grid[i][j] = '0';
        for (int[] dir : dirs) {
            int nextI = i + dir[0];
            int nextJ = j + dir[1];
            dfs(grid, nextI, nextJ);
        }

        // 离开时的操作
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        char[][] grid2 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        char[][] grid3 = {
                {'1', '1', '1', '1', '1', '1', '1', '0'},
                {'1', '0', '0', '0', '0', '1', '1', '0'},
                {'1', '0', '1', '0', '1', '1', '1', '0'},
                {'1', '0', '0', '0', '0', '1', '0', '1'},
                {'1', '1', '1', '1', '1', '1', '1', '0'}
        };

        Solution solut = new Solution();
        System.out.println(solut.numIslands(grid3));
    }
}
