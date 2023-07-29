package Chapter3.暴力搜索算法.回溯算法解题套路框架.T51;

// N皇后问题
// 回溯法
// 难点：如何判断已经获得一个合法结果

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<String>> ans;

    public List<List<String>> solveNQueens(int n) {
        ans = new ArrayList<>();
        List<String> board = new ArrayList<>();

        // 初始化board
        char[] chs = new char[n];
        for (int i = 0; i < n; i++){
            chs[i] = '.';
        }
        for (int i = 0; i < n; i++){
            board.add(String.valueOf(chs));
        }

        backtrace(board, 0);
        return ans;
    }

    // 这里的board是选择列表，row是已选路径
    public void backtrace(List<String> board, int row) {
        // 结束条件
        if (row == board.size()) {
            ans.add(new ArrayList<>(board));
            return;
        }

        int n = board.size();
        for (int col = 0; col < n; col++) {
            // 剪枝
            if (!isValid(board, row, col)) {
                continue;
            }

            char[] chs = new char[n];
            for (int i = 0; i < n; i++){
                if (i == col){
                    chs[i] = 'Q';
                }else{
                    chs[i] = '.';
                }
            }
            // 做选择
            board.set(row, String.valueOf(chs));

            // 进入下一行决策
            backtrace(board, row + 1);

            chs[col] = '.';
            // 撤销选择
            board.set(row, String.valueOf(chs));
        }
    }

    // 判断当前结果是否合法
    // 这里的board存储棋盘的格式为 [".Q..","...Q","Q...","..Q."]
    public boolean isValid(List<String> board, int row, int col) {
        int n = board.size();

        // 检查列是否有皇后互相冲突
        for (int i = 0; i < n; i++) {
            String s = board.get(i);
            if (s.charAt(col) == 'Q') {
                return false;
            }
        }

        // 检查右上方是否有皇后互相冲突
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            String s = board.get(i);
            if (s.charAt(j) == 'Q') {
                return false;
            }
        }

        // 检查左上方是否有皇后相互冲突
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            String s = board.get(i);
            if (s.charAt(j) == 'Q') {
                return false;
            }
        }
        return true;
    }
    // 为什么不检查左下角，右下角和下方的格子，
    // 只检查了左上角，右上角和上方的格子呢？

    // 因为皇后是一行一行从上往下放的，所以左下方，右下方和正下方不用检查（还没放皇后）；
    // 因为一行只会放一个皇后，所以每行不用检查。
    // 也就是最后只用检查上面，左上，右上三个方向。

    // Q . . . . . . .
    // . Q . . . . . .
    // . . Q . . . . .
    // . . . Q . . . .

    // . . . Q . . . .
    // . . . Q . . . .
    // . . . Q . . . .
    // . . . Q . . . .

    // . . . . . . . Q
    // . . . . . . Q .
    // . . . . . Q . .
    // . . . . Q . . .
}
