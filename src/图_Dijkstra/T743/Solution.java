package 图_Dijkstra.T743;

import java.util.*;

class State {
    // 图节点的id
    int id;

    // 从start节点到当前节点的路径
    int distFromStart;

    public State(int id, int distFromStart) {
        this.id = id;
        this.distFromStart = distFromStart;
    }
}

public class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // 节点编号是从1开始的，所有要一个大小为n+1的邻接表
        List<int[]>[] graph = new LinkedList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new LinkedList<>();
        }

        // 构造图
        for (int[] edge : times) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];

            // from -> List<(to, weight)>
            // 邻接表存储图结构，同时存储权重信息
            graph[from].add(new int[]{to, weight});
        }

        // 启动dijkstra算法计算以节点k为起点到其他节点的最短路径
        int[] distTo = dijkstra(k, graph);

        // 找到最长的那一条最短路径
        int res = 0;
        for (int i = 1; i < distTo.length; i++) {
            if (distTo[i] == Integer.MAX_VALUE) {
                // 有节点不可达，返回-1
                return -1;
            }
            res = Math.max(res, distTo[i]);
        }
        return res;
    }

    // 输入一个起点start，计算从start到其他节点的最短路径
    public int[] dijkstra(int start, List<int[]>[] graph) {
        // 定义：distTo[i]的值就是起点start到达节点i的最短路径权重
        int[] distTo = new int[graph.length];
        Arrays.fill(distTo, Integer.MAX_VALUE);

        // base case, start到start的最短路径就是0
        distTo[start] = 0;

        // 优先级队列，distFromStart较小的排在前面
        Queue<State> pq = new PriorityQueue<>((a, b) -> {
            return a.distFromStart - b.distFromStart;
        });

        // 从起点start开始进行BFS
        pq.offer(new State(start, 0));

        while (!pq.isEmpty()) {
            State curState = pq.poll();
            int curNodeID = curState.id;
            int curDistFromStart = curState.distFromStart;

            if (curDistFromStart > distTo[curNodeID]) {
                continue;
            }

            // 将curNode的相邻节点装入队列
            for (int[] neighbor : graph[curNodeID]) {
                int nextNodeID = neighbor[0];
                int distToNextNode = distTo[curNodeID] + neighbor[1];
                // 更新dp table
                if (distTo[nextNodeID] > distToNextNode) {
                    distTo[nextNodeID] = distToNextNode;
                    pq.offer(new State(nextNodeID, distToNextNode));
                }
            }
        }

        return distTo;
    }

    public static void main(String[] args) {
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int n = 4;
        int k = 2;

        int[][] times2 = {{1, 2, 1}};
        int n2 = 2;
        int k2 = 1;

        int[][] times3 = {{1, 2, 1}};
        int n3 = 2;
        int k3 = 2;

        Solution solut = new Solution();
        System.out.println(solut.networkDelayTime(times, n, k));
    }
}
