package kwq.huawei0831;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    Scanner scan = new Scanner(System.in);
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int steps = Integer.MAX_VALUE;
    Set<Integer> isWall = new HashSet<>();

    public Main() {
        String NM = scan.nextLine();
        String[] nm = NM.split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            String row = scan.nextLine();
            String[] rows = row.split(" ");
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(rows[j]);
            }
        }

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
        System.out.println(steps);
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
        new Main();
    }
}
