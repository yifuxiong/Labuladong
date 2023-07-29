package ali.T1;

// LeetCode T529.扫雷问题

// 'M' 代表一个 未挖出的 地雷，
// 'E' 代表一个 未挖出的 空方块，
// 'B' 代表没有相邻（上，下，左，右，和所有4个对角线）地雷的 已挖出的 空白方块，
// 数字（'1' 到 '8'）表示有多少地雷与这块 已挖出的 方块相邻，
// 'X' 则表示一个 已挖出的 地雷。

// 点击之后按照规则触发事件：
// 1.如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X' 。
// 2.如果一个 没有相邻地雷 的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的 未挖出 方块都应该被递归地揭露。
// 3.如果一个 至少与一个地雷相邻 的空方块（'E'）被挖出，修改它为数字（'1' 到 '8' ），表示相邻地雷的数量。
// 4.如果在此次点击中，若无更多方块可被揭露，则返回盘面。


public class MineSweeper {
    int[] dirX = {0, 1, 0, -1, 1, 1, -1, -1};
    int[] dirY = {1, 0, -1, 0, 1, -1, 1, -1};

    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0], y = click[1];
        if (board[x][y] == 'M') {
            // 规则1：踩到雷
            board[x][y] = 'X';
        } else {
            // 规则2,3,4
            dfs(board, x, y);
        }
        return board;
    }

    public void dfs(char[][] board, int x, int y) {
        int m = board.length, n = board[0].length;

        // 地雷计数
        int cnt = 0;
        for (int i = 0; i < 8; i++) {
            // 周围8个方向
            int tx = x + dirX[i];
            int ty = y + dirY[i];

            // 越界
            if (tx < 0 || tx >= m || ty < 0 || ty >= n) {
                continue;
            }

            // 不用判断 M，因为如果有 M 的话游戏已经结束了

            // 周围8格地雷的数量
            if (board[tx][ty] == 'M') {
                cnt++;
            }
        }

        if (cnt > 0) {
            // 规则3：如果周围8格有地雷
            board[x][y] = (char) (cnt + '0');
        } else {
            // 规则2：如果周围8格没有地雷
            board[x][y] = 'B';
            for (int i = 0; i < 8; i++) {
                int tx = x + dirX[i];
                int ty = y + dirY[i];

                // 这里不需要在存在 B 的时候继续扩展，
                // 因为 B 之前被点击的时候已经被扩展过了
                if (tx < 0 || tx >= m || ty < 0 || ty >= n || board[tx][ty] != 'E') {
                    continue;
                }
                dfs(board, tx, ty);
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = {
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'M', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'}
        };
        int[] click = {3, 0};

        char[][] board2 = {
                {'B', '1', 'E', '1', 'B'},
                {'B', '1', 'M', '1', 'B'},
                {'B', '1', '1', '1', 'B'},
                {'B', 'B', 'B', 'B', 'B'}
        };
        int[] click2 = {1, 2};

        MineSweeper ms = new MineSweeper();
        char[][] newBoard = ms.updateBoard(board2, click2);
        for (char[] row : newBoard) {
            for (char col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
        System.out.println();

    }
}
