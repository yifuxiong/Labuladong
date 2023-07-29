package kwq.huawei0831;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int steps = Integer.MAX_VALUE;
    Set<Integer> isWall = new HashSet<>();

    public int leastStep(int[][] grid, int n, int m) {
        // 0为路，1为墙
        // 2为起点，3为终点
        // 4为陷阱，6为炸弹
        int startX = 0, startY = 0;
        int endX = 0, endY = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    startX = i;
                    startY = j;
                } else if (grid[i][j] == 3) {
                    endX = i;
                    endY = j;
                }
            }
        }

        dfs(grid, 0, startX, startY, endX, endY);
        return steps;
    }

    public void dfs(int[][] grid, int cost, int x, int y, int endX, int endY) {
        int n = grid.length;
        int m = grid[0].length;

        if (grid[x][y] == 3 || x == endX && y == endY) {
            steps = Math.min(steps, cost);
            return;
        }

        if (grid[x][y] == -1) {
            return;
        }

//        if (grid[x][y] == 1) {
//            return;
//        }

        // System.out.println(grid[x][y]);

        int sign = grid[x][y];
        for (int[] dir : dirs) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];

            if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) {
                continue;
            }

            // 标记为走过
            grid[x][y] = -1;

            if (grid[nextX][nextY] == 4) {
                cost += 3;
            } else if (grid[nextX][nextY] == 6) {
                cost += 1;
                if (nextX + 1 < n && nextY + 1 < m && grid[nextX + 1][nextY + 1] == 1) {
                    isWall.add(((nextX + 1) << 8 + (nextY + 1)));
                    grid[nextX + 1][nextY + 1] = 0;
                }
                if (nextX + 1 < n && nextY - 1 >= 0 && grid[nextX + 1][nextY - 1] == 1) {
                    isWall.add(((nextX + 1) << 8 + (nextY - 1)));
                    grid[nextX + 1][nextY - 1] = 0;
                }
                if (nextX - 1 >= 0 && nextY + 1 < m && grid[nextX - 1][nextY + 1] == 1) {
                    isWall.add(((nextX - 1) << 8 + (nextY + 1)));
                    grid[nextX - 1][nextY + 1] = 0;
                }
                if (nextX - 1 >= 0 && nextY - 1 >= 0 && grid[nextX - 1][nextY - 1] == 1) {
                    isWall.add(((nextX - 1) << 8 + (nextY - 1)));
                    grid[nextX - 1][nextY - 1] = 0;
                }
            } else {
                cost += 1;
            }

            dfs(grid, cost, nextX, nextY, endX, endY);

            if (grid[nextX][nextY] == 4) {
                cost -= 3;
            } else if (grid[nextX][nextY] == 6) {
                cost -= 1;
                if (nextX + 1 < n && nextY + 1 < m && grid[nextX + 1][nextY + 1] == 0 && isWall.contains(((nextX + 1) << 8 + (nextY + 1)))) {
                    grid[nextX + 1][nextY + 1] = 1;
                    isWall.remove(((nextX + 1) << 8 + (nextY + 1)));
                }
                if (nextX + 1 < n && nextY - 1 >= 0 && grid[nextX + 1][nextY - 1] == 0 && isWall.contains(((nextX + 1) << 8 + (nextY - 1)))) {
                    grid[nextX + 1][nextY - 1] = 1;
                    isWall.remove(((nextX + 1) << 8 + (nextY - 1)));
                }
                if (nextX - 1 >= 0 && nextY + 1 < m && grid[nextX - 1][nextY + 1] == 0 && isWall.contains(((nextX - 1) << 8 + (nextY + 1)))) {
                    grid[nextX - 1][nextY + 1] = 1;
                    isWall.remove(((nextX - 1) << 8 + (nextY + 1)));
                }
                if (nextX - 1 >= 0 && nextY - 1 >= 0 && grid[nextX - 1][nextY - 1] == 0 && isWall.contains(((nextX - 1) << 8 + (nextY - 1)))) {
                    grid[nextX - 1][nextY - 1] = 1;
                    isWall.remove(((nextX - 1) << 8 + (nextY - 1)));
                }
            } else {
                cost -= 1;
            }

            // 还原走过
            grid[x][y] = sign;
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int m = 4;
        int[][] grid = {
                {1, 1, 1, 1},
                {1, 6, 2, 1},
                {1, 1, 0, 1},
                {1, 3, 1, 1}
        };  // out = 3

        int n2 = 8;
        int m2 = 4;
        int[][] grid2 = {
                {1, 6, 2, 1},
                {1, 1, 0, 1},
                {1, 1, 0, 1},
                {1, 1, 0, 1},
                {1, 1, 0, 1},
                {1, 1, 0, 1},
                {1, 1, 0, 1},
                {1, 1, 3, 1},
        };  // out = 7

        Solution solut = new Solution();
        System.out.println(solut.leastStep(grid, n, m));
    }
}
