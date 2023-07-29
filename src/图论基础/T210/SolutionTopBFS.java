package 图论基础.T210;

// 环检测算法
// 拓扑排序（BFS板）

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SolutionTopBFS {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);

        int[] indegree = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            int from = prerequisite[0];
            int to = prerequisite[1];
            indegree[to]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] ans = new int[numCourses];
        int count = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            ans[count++] = cur;
            for (int v : graph[cur]) {
                indegree[v]--;
                if (indegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        if (count != numCourses) {
            // 有环
            return new int[]{};
        }
        return ans;
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

        SolutionTopBFS soluttopbfs = new SolutionTopBFS();
        int[] ans = soluttopbfs.findOrder(numCourses2, prerequisites2);
        for (int a : ans) {
            System.out.print(a + ", ");
        }
        System.out.println();
    }
}
