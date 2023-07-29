package 回溯法.解数独.T37;

public class Solution {
    public void solveSudoku(char[][] board) {
        backTrack(board, 0, 0);
    }

    public boolean backTrack(char[][] board, int row, int col) {
        // 这一行结束了，下一行开始
        if (col == 9) {
            return backTrack(board, row + 1, 0);
        }
        if (row == 9) {
            return true;
        }

        if (board[row][col] != '.') {
            return backTrack(board, row, col + 1);
        }

        for (char num = '1'; num <= '9'; num++) {
            if (!isValid(board, row, col, num)) {
                continue;
            }

            board[row][col] = num;
            if (backTrack(board, row, col + 1)) {
                return true;
            }
            board[row][col] = '.';
        }
        return false;
    }

    public boolean isValid(char[][] board, int row, int col, char num) {
        // 数字 1-9 在每一行只能出现一次
        // 数字 1-9 在每一列只能出现一次
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) {
                return false;
            }
            if (board[row][i] == num) {
                return false;
            }
        }

        // 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次
        // 在第几个九宫格
        int x = row / 3;
        int y = col / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int px = x * 3 + i;
                int py = y * 3 + j;
                if (board[px][py] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        Solution solut = new Solution();
        solut.solveSudoku(board);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
