package 图_Dijkstra.T1514;

import java.util.*;

class State {
    int id;
    // 从起始节点到当前节点的成功概率
    double succ;

    public State(int id, double succ) {
        this.id = id;
        this.succ = succ;
    }
}

public class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<double[]>[] graph = adj(n, edges, succProb);

        // 从起点到当前点的概率，用这个数组存储最终的结果
        double[] prob = new double[n];
        for (int i = 0; i < n; i++) {
            prob[i] = 0;
        }
        // 自己到自己概率为1
        prob[start] = 1;

        Queue<State> queue = new PriorityQueue<>(new Comparator<State>() {
            public int compare(State a, State b) {
                if (b.succ >= a.succ) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        queue.offer(new State(start, 1));

        while (!queue.isEmpty()) {
            State curState = queue.poll();
            int curId = curState.id;
            double curSucc = curState.succ;

            // 如果遇到终点，直接返回结果
            if (curId == end) {
                return curSucc;
            }

            if (curSucc < prob[curId]) {
                continue;
            }

            for (double[] neighbor : graph[curId]) {
                int nextId = (int) neighbor[0];
                double nextSucc = prob[curId] * neighbor[1];

                if (prob[nextId] < nextSucc) {
                    prob[nextId] = nextSucc;
                    queue.offer(new State(nextId, nextSucc));
                }
            }
        }

        return 0;
    }

    public List<double[]>[] adj(int n, int[][] edges, double[] succProb) {
        List<double[]>[] graph = new LinkedList[n];
        // graph初始化
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            double succ = succProb[i];
            // 无向图就是双向图
            graph[from].add(new double[]{(double) to, succ});
            graph[to].add(new double[]{(double) from, succ});
        }
        return graph;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {{0, 1}, {1, 2}, {0, 2}};
        double[] succProb = {0.5, 0.5, 0.2};
        int start = 0;
        int end = 2;

        Solution solut = new Solution();
        System.out.println(solut.maxProbability(n, edges, succProb, start, end));
    }
}
