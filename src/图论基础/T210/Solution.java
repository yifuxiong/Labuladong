package 图论基础.T210;

// 环检测算法
// 拓扑排序（DFS板）

import java.util.*;

public class Solution {
    private boolean[] visited;
    private boolean[] onPath;
    private boolean hasCycle = false;
    private List<Integer> postOrder;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];
        postOrder = new LinkedList<>();

        List<Integer>[] graph = buildGraph(numCourses, prerequisites);

        // 遍历所有节点，只要存在环，那么就不能进行拓扑排序
        for (int i = 0; i < numCourses; i++) {
            traverse(graph, i);
        }

        if (hasCycle) {
            return new int[]{};
        }

        // buildGraph中，from和to反过来了，所以不用reverse后序遍历
        // Collections.reverse(postOrder);
        int[] ans = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            ans[i] = postOrder.get(i);
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

    public void traverse(List<Integer>[] graph, int s) {
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

        postOrder.add(s);
        onPath[s] = false;
    }

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}};

        int numCourses2 = 4;
        int[][] prerequisites2 = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};

        Solution solut = new Solution();
        int[] ans = solut.findOrder(numCourses2, prerequisites2);
        for (int a : ans) {
            System.out.print(a + ", ");
        }
        System.out.println();

    }
}
