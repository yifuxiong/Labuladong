package 图_Dijkstra.T787_flag;

import java.util.*;

class State {
    int id;
    int price;  // 到达当前这一站 最少 & 总共 花了多少钱
    int num;  // 表示转了多少站

    public State(int id, int price, int num) {
        this.id = id;
        this.price = price;
        this.num = num;
    }
}

public class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<int[]>[] graph = buildGraph(n, flights);

        // 起点到终点的cost
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;

        Queue<State> pq = new PriorityQueue<>(new Comparator<State>() {
            public int compare(State s1, State s2) {
                if (s1.price < s2.price) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        // 图中没有环，自己到自己的价格为0
        pq.offer(new State(src, 0, 0));

        while (!pq.isEmpty()) {
            State cur = pq.poll();
            int id = cur.id;
            int price = cur.price;
            int num = cur.num;

            if (price > cost[id]) {
                continue;
            }

            if (num > k) {
                continue;
            }

            for (int[] next : graph[id]) {
                int nextId = next[0];
                // 到下一站的费用加上前面所花的费用
                int nextPrice = price;
                if (price != Integer.MAX_VALUE) {
                    nextPrice += next[1];
                }

                if (cost[nextId] > nextPrice) {
                    cost[nextId] = nextPrice;
                    pq.offer(new State(nextId, nextPrice, num + 1));
                }
            }
        }

        //    for (int i = 0; i < n; i++) {
        //        System.out.print(cost[i] + ", ");
        //    }
        //    System.out.println();

        return (cost[dst] == Integer.MAX_VALUE || cost[dst] == 0) ? -1 : cost[dst];
    }

    public List<int[]>[] buildGraph(int n, int[][] flights) {
        List<int[]>[] graph = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];
            graph[from].add(new int[]{to, price});
        }
        return graph;
    }
}
