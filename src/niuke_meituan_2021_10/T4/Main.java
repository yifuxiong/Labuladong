package niuke_meituan_2021_10.T4;

import java.util.*;

// 树形dp
// 三维dp
public class Main {
    Scanner scan = new Scanner(System.in);
    int[][][] memo;
    int[] weights;

    public Main() {
        int n = Integer.parseInt(scan.nextLine());
        String s = scan.nextLine();
        String[] str = s.split(" ");
        weights = new int[n];
        for (int i = 0; i < n; i++) {
            weights[i] = Integer.parseInt(str[i]);
        }

        // dp
        memo = new int[n][n][n];
        // base case
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    memo[i][j][k] = -1;
                }
            }
        }

        int ans = dfs(weights, 0, n - 1, -1);
        System.out.println(ans);
    }

    public int dfs(int[] weights, int left, int right, int root) {
        if (left > right) {
            return 0;
        }
        if (root >= 0 && memo[left][right][root] != -1) {
            return memo[left][right][root];
        }

        int cost = Integer.MAX_VALUE;
        for (int i = left; i <= right; i++) {
            int leftCost = dfs(weights, left, i - 1, i);
            int rightCost = dfs(weights, i + 1, right, i);
            int rootCost = weights[i] * (root != -1 ? weights[root] : 0);
            cost = Math.min(cost, leftCost + rightCost + rootCost);
        }

        if (root >= 0) {
            memo[left][right][root] = cost;
        }
        return cost;
    }

    public static void main(String[] args) {
        new Main();
    }
}
