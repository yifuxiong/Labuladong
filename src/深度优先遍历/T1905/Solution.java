package 深度优先遍历.T1905;

public class Solution {
    private int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int ans;

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        // 先在grid2中，将1的位置却在grid1中却是0的位置，删除
        // 即先将不可能是子岛屿的位置排除
        ans = 0;
        int m = grid2.length, n = grid2[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1 && grid1[i][j] == 0) {
                    dfs(grid2, i, j);
                }
            }
        }

        // 再来找子岛屿
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1) {
                    ans++;
                    dfs(grid2, i, j);
                }
            }
        }

        return ans;
    }

    public void dfs(int[][] grid2, int i, int j) {
        int m = grid2.length, n = grid2[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return;
        }

        if (grid2[i][j] == 0) {
            return;
        }

        grid2[i][j] = 0;
        for (int[] dir : dirs) {
            int nextI = i + dir[0];
            int nextJ = j + dir[1];
            dfs(grid2, nextI, nextJ);
        }

    }

    public static void main(String[] args) {
        int[][] grid1 = {
                {1, 1, 1, 0, 0},
                {0, 1, 1, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 1, 1}
        };

        int[][] grid2 = {
                {1, 1, 1, 0, 0},
                {0, 0, 1, 1, 1},
                {0, 1, 0, 0, 0},
                {1, 0, 1, 1, 0},
                {0, 1, 0, 1, 0}
        };

        Solution solut = new Solution();
        System.out.println(solut.countSubIslands(grid1, grid2));
    }
}
