package 图_Dijkstra.T1631;

import java.util.*;

class State {
    // 矩阵中的一个位置
    int x;
    int y;
    // 从起点 (0, 0) 到当前位置的最小体力消耗（距离）
    int effortFromStart;

    public State(int x, int y, int effortFromStart) {
        this.x = x;
        this.y = y;
        this.effortFromStart = effortFromStart;
    }
}

public class Solution {
    private int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        // 从(0,0)到(i,j)的最小体力消耗是effortTo[i][j]
        int[][] effortTo = new int[m][n];
        // 初始化
        for (int i = 0; i < n; i++) {
            Arrays.fill(effortTo[i], Integer.MAX_VALUE);
        }
        effortTo[0][0] = 0;

        Queue<State> queue = new PriorityQueue<>((a, b) -> {
            return a.effortFromStart - b.effortFromStart;
        });

        // 从(0,0)开始进行BFS
        queue.offer(new State(0, 0, 0));

        while (!queue.isEmpty()) {
            State curState = queue.poll();
            int curX = curState.x;
            int curY = curState.y;
            int curEffortFromStart = curState.effortFromStart;

            // 如果到达终点，提前结束
            if (curX == m - 1 && curY == n - 1) {
                return curEffortFromStart;
            }

            if (curEffortFromStart > effortTo[curX][curY]) {
                continue;
            }

            for (int[] neighbor : adj(heights, curX, curY)) {
                int nextX = neighbor[0];
                int nextY = neighbor[1];
                int effortToNextNode = Math.max(effortTo[curX][curY],
                        Math.abs(heights[curX][curY] - heights[nextX][nextY]));

                if (effortToNextNode < effortTo[nextX][nextY]) {
                    effortTo[nextX][nextY] = effortToNextNode;
                    queue.offer(new State(nextX, nextY, effortToNextNode));
                }
            }
        }

        return -1;
    }

    // 对一个节点，按照广度优先，朝4个方向构建图
    public List<int[]> adj(int[][] matrix, int x, int y) {
        int m = matrix.length, n = matrix[0].length;
        List<int[]> neighbors = new ArrayList<>();
        for (int[] dir : dirs) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];
            if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n) {
                continue;
            }
            neighbors.add(new int[]{nextX, nextY});
        }
        return neighbors;
    }

    public static void main(String[] args) {
        int[][] heights = {{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};

        Solution solut = new Solution();
        System.out.println(solut.minimumEffortPath(heights));
    }
}
