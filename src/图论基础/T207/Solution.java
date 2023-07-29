package 图论基础.T207;

// 环检测算法
// 两种思路：DFS和BFS
// 方法：裸DFS，裸BFS，拓扑排序（DFS版本和BFS版本）
// 本题是裸DFS

import java.util.LinkedList;
import java.util.List;

public class Solution {
    private boolean[] visited;
    private boolean[] onPath;
    private boolean hasCycle;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];
        hasCycle = false;

        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        for (int i = 0; i < numCourses; i++) {
            traverse(graph, i);
        }

        return !hasCycle;
    }

    // 构建邻接表
    public List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int[] prerequisite : prerequisites) {
            int from = prerequisite[0], to = prerequisite[1];
            graph[from].add(to);
        }

        return graph;
    }

    public void traverse(List<Integer>[] graph, int s) {
        // 如果最终路径中发现有重复节点
        if (onPath[s]) {
            hasCycle = true;
        }

        if (visited[s] || hasCycle) {
            return;
        }

        visited[s] = true;
        onPath[s] = true;
        for (int v : graph[s]) {
            traverse(graph, v);
        }
        onPath[s] = false;
    }

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}};

        int numCourses2 = 2;
        int[][] prerequisites2 = {{1, 0}, {0, 1}};

        Solution solut = new Solution();
        System.out.println(solut.canFinish(numCourses, prerequisites));
    }
}
