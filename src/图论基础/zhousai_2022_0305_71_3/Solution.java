package 图论基础.zhousai_2022_0305_71_3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> getParents(int n, int[][] edges) {
        List<List<Integer>> ans = new LinkedList<>();
        List<Integer>[] graph = buildGraph(n, edges);
        // 先找入度为0的节点
        int[] indegree = new int[n];
        for (int[] edge : edges) {
            indegree[edge[1]]++;
        }

        List<Integer> nodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                nodes.add(i);
            }
        }

        for (int j = 0; j < n; j++) {
            List<Integer> paths = new LinkedList<>();
            for (int i : nodes) {
                List<Integer> path = new LinkedList<>();
                dfs(graph, i, j, path, new LinkedList<>());
                // traverse(graph, i, j, ans, new LinkedList<>());

                for (int p : path) {
                    if (!paths.contains(p)) {
                        paths.add(p);
                    }
                }
            }
            ans.add(paths);
        }
        return ans;
    }

    public void dfs(List<Integer>[] graph, int start, int end, List<Integer> path, LinkedList<Integer> tmp) {
        tmp.addLast(start);

        // 剪枝
        if (start > end) {
            return;
        }

        if (start == end) {
            // 自己这个节点不要加进去
            tmp.removeLast();
            for (int t : tmp) {
                if (!path.contains(t)) {
                    path.add(t);
                }
            }
            return;
        }

        for (int v : graph[start]) {
            dfs(graph, v, end, path, tmp);
        }

        tmp.removeLast();
    }

//    public void traverse(List<Integer>[] graph, int start, int end, List<List<Integer>> onPath, LinkedList<Integer> tmp) {
//        tmp.addLast(start);
//
//        // 剪枝
//        if (start > end) {
//            return;
//        }
//
//        if (start == end) {
//            onPath.add(new LinkedList<>(tmp));
//            tmp.removeLast();
//            return;
//        }
//
//        for (int v : graph[start]) {
//            traverse(graph, v, end, onPath, tmp);
//        }
//
//        tmp.removeLast();
//    }

    public List<Integer>[] buildGraph(int n, int[][] edges) {
        List<Integer>[] graph = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            graph[from].add(to);
        }
        return graph;
    }

    public static void main(String[] args) {
        int n = 8;
        int[][] edges = {
                {0, 3}, {0, 4}, {1, 4},
                {1, 5}, {2, 5}, {3, 6},
                {4, 6}, {4, 7}, {5, 7}
        };

        Solution solut = new Solution();
        List<List<Integer>> ans = solut.getParents(n, edges);
        for (List<Integer> a : ans) {
            System.out.println(a);
        }
    }
}
