package Chapter3.暴力搜索算法.BFS算法秒杀智力题.T773;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {
    public int slidingPuzzle(int[][] board) {
        // 将board看成一维，根据0的位置，找它的邻域位置的索引
        int[][] neighbors = {
                {1, 3},  // 0在左上角  0
                {0, 2, 4},  // 0在第一行中间  1
                {1, 5},  // 右上角  2
                {0, 4},  // 左下角  3
                {1, 3, 5},  // 第二行中间  4
                {2, 4}  // 右下角  5
        };

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                sb.append(board[i][j]);
            }
        }

        Deque<String> queue = new ArrayDeque<>();
        queue.offer(sb.toString());

        if (sb.toString().equals("123450")) {
            return 0;
        }

        List<String> visited = new ArrayList<>();
        visited.add(sb.toString());

        int step = 0;

        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String tmp = queue.poll();

                // 找当前序列中0的位置
                int pos = 0;
                while (pos < tmp.length()) {
                    if (tmp.charAt(pos) == '0') {
                        break;
                    }
                    pos++;
                }

                // 将0与目标邻居交换位置后生成新的字符串
                // 将新字符串插入队列
                for (int des : neighbors[pos]) {
                    String res = swap(tmp, pos, des);

                    if (!visited.contains(res)) {
                        if (res.equals("123450")) {
                            return step;
                        }
                        queue.offer(res);
                        visited.add(res);
                    }
                }
            }
        }
        return -1;
    }

    public String swap(String tmp, int pos, int des) {
        char[] chs = tmp.toCharArray();
        char t = chs[pos];
        chs[pos] = chs[des];
        chs[des] = t;
        return new String(chs);
    }

    public static void main(String[] args) {
        int[][] board = {{1, 2, 3}, {4, 0, 5}};
        int[][] board2 = {{1, 2, 3}, {5, 4, 0}};
        int[][] board3 = {{4, 1, 2}, {5, 0, 3}};
        int[][] board4 = {{3, 2, 4}, {1, 5, 0}};

        Solution solut = new Solution();
        System.out.println(solut.slidingPuzzle(board4));
    }
}
