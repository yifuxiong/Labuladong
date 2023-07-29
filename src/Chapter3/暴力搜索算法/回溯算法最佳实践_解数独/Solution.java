package Chapter3.暴力搜索算法.回溯算法最佳实践_解数独;

// 解数独
// 二维数组的回溯

public class Solution {
    public void solveSudoku(char[][] board) {
        backTrack(board, 0, 0);
    }

    // 每行每行的填数
    public boolean backTrack(char[][] board, int row, int col) {
        // 触发条件
        if (col == 9) {
            // 这一行结束了，下一行开始
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

    public boolean isValid(char[][] board, int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            // 保证每行只出现一次
            if (board[row][i] == num) {
                return false;
            }
            // 保证每列只出现一次
            if (board[i][col] == num) {
                return false;
            }
        }

        // 保证每个9宫格只出现一次
        // 先判断是哪个9宫格
        int x = row / 3;
        int y = col / 3;
        // num在该9宫格的哪个位置
        int r = row % 3;
        int c = col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[3 * x + i][3 * y + j] == num) {
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
