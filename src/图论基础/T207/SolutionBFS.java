package 图论基础.T207;

// 环检测算法
// 裸BFS
// 从入度这个角度下手

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SolutionBFS {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);

        // 构建入度数组
        int[] indegree = new int[numCourses];
        for (int[] edge : prerequisites) {
            int from = edge[0];
            int to = edge[1];
            // 入度+1
            indegree[to]++;
        }

        // 根据入度初始化队列中的节点
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                // 没有入度，作为拓扑排序的起点
                q.offer(i);
            }
        }

        // 记录遍历节点的个数
        int count = 0;
        // 开始执行BFS循环
        while (!q.isEmpty()) {
            // 弹出节点cur，并将它指向节点的入度-1
            int cur = q.poll();
            count++;
            for (int next : graph[cur]) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    // 如果入度变为0，说明next依赖的节点都已被遍历
                    q.offer(next);
                }
            }
        }

        // 如果所有节点都被遍历过，说明不成环
        return count == numCourses;
    }

    public List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new LinkedList[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int[] prerequisite : prerequisites) {
            int from = prerequisite[0];
            int to = prerequisite[1];
            graph[from].add(to);
        }

        return graph;
    }

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}};

        int numCourses2 = 4;
        int[][] prerequisites2 = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};

        SolutionBFS solutbfs = new SolutionBFS();
        System.out.println(solutbfs.canFinish(numCourses, prerequisites));
    }
}
