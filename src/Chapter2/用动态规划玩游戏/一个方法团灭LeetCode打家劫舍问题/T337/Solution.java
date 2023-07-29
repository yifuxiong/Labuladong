package Chapter2.用动态规划玩游戏.一个方法团灭LeetCode打家劫舍问题.T337;

import java.util.HashMap;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    // 暴力dfs超时
    public int rob(TreeNode root) {
        int res = 0;
        res = Math.max(res, Math.max(dfs(root, true), dfs(root, false)));
        return res;
    }

    public int dfs(TreeNode root, boolean ifPre) {
        if (root == null) {
            return 0;
        }

        if (ifPre) {
            // 上一个节点已经取了，当前节点不能取
            int leftVal = dfs(root.left, false);
            int rightVal = dfs(root.right, false);
            return leftVal + rightVal;
        } else {
            // 取当前节点
            int leftVal = dfs(root.left, true);
            int rightVal = dfs(root.right, true);
            int preSumVal = root.val + leftVal + rightVal;

            // 不取当前节点
            int leftValN = dfs(root.left, false);
            int rightValN = dfs(root.right, false);
            int preSumValN = leftValN + rightValN;

            return Math.max(preSumVal, preSumValN);
        }
    }

    Map<TreeNode, Integer> memo = new HashMap<>();

    // 记忆化递归
    public int rob2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (memo.containsKey(root)) {
            return memo.get(root);
        }

        int money = root.val;
        if (root.left != null) {
            money += (rob2(root.left.left) + rob2(root.left.right));
        }

        if (root.right != null) {
            money += (rob2(root.right.left) + rob2(root.right.right));
        }

        int res = Math.max(money, rob2(root.left) + rob2(root.right));
        memo.put(root, res);
        return res;
    }

    // 记忆化递归
    public int rob3(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    public int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }

        int[] res = new int[2];
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        // 当前节点不取，子节点可以选择取或者不取
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        // 当前节点取了，那么两个子节点只能不取
        res[1] = root.val + left[0] + right[0];

        return res;
    }
}
