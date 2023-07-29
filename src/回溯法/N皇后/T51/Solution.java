package 回溯法.N皇后.T51;

// 回溯法巅峰

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    List<List<String>> ans;

    public List<List<String>> solveNQueens(int n) {
        ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] b : board) {
            Arrays.fill(b, '.');
        }
        backTrace(board, 0);
        return ans;
    }

    public void backTrace(char[][] board, int row) {
        int n = board.length;
        if (row == n) {
            List<String> tmp = new ArrayList<>();
            for (char[] b : board) {
                StringBuffer line = new StringBuffer();
                for (char c : b) {
                    line.append(c);
                }
                tmp.add(line.toString());
            }
            ans.add(new ArrayList<>(tmp));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (!isValid(board, row, col)) {
                continue;
            }

            board[row][col] = 'Q';
            backTrace(board, row + 1);
            board[row][col] = '.';
        }
    }

    public boolean isValid(char[][] board, int row, int col) {
        int n = board.length;
        // 竖直方向上冲突
        for (int i = 0; i < n && i != row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // 左上方向上冲突
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // 右上方向上冲突
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int n = 4;

        Solution solut = new Solution();
        System.out.println(solut.solveNQueens(n));
    }
}
