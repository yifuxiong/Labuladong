package ali.T1;

// 类似于 LeetCode T529.扫雷游戏
// dfs

// 确定是雷替换成'X'，确定不是雷替换成'O'
// 不确定保持'.'，已经是数字的保持是数字

public class Solution {
    int[] dirX = {0, 1, 0, -1, 1, 1, -1, -1};
    int[] dirY = {1, 0, -1, 0, 1, -1, 1, -1};

    public String[] mineSweeper(String[] origin) {
        // 输入的board确定是4x4大小
        int n = origin.length;
        char[][] board = new char[n][n];
        int a = 0;
        for (String s : origin) {
            for (int i = 0; i < n; i++) {
                board[a][i] = s.charAt(i);
            }
            a++;
        }

        return origin;
    }

    public static void main(String[] args) {
        String[] origin = {"1...", "..2.", ".2..", "...1"};

        Solution solut = new Solution();
        String[] ans = solut.mineSweeper(origin);
        for (String a : ans) {
            System.out.println(a);
        }
    }
}
