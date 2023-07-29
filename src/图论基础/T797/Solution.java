package 图论基础.T797;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    // 保存所有最终路径
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        // 维护递归过程中经过的路径
        LinkedList<Integer> path = new LinkedList<>();
        traverse(graph, 0, path);
        return res;
    }

    public void traverse(int[][] graph, int s, LinkedList<Integer> path) {
        // 添加节点s到路径
        path.addLast(s);

        int n = graph.length;
        if (s == n - 1) {
            // 到达终点
            res.add(new LinkedList<>(path));
            // 根据图论基础那一章中的一个gif图（1.gif）
            // 绿色的点表示onPath
            // 这里就是退回onPath的最后一个节点
            path.removeLast();
            return;
        }

        // 递归每个相邻节点
        for (int v : graph[s]) {
            traverse(graph, v, path);
        }

        // 从路径移除节点s
        path.removeLast();
    }

    public static void main(String[] args) {
        int[][] graph = {
                {1, 2},
                {3},
                {3},
                {}
        };

        int[][] graph2 = {
                {4, 3, 1},
                {3, 2, 4},
                {3},
                {4},
                {}
        };

        Solution solut = new Solution();
        System.out.println(solut.allPathsSourceTarget(graph));
    }
}
