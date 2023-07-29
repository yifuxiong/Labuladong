package Chapter1.二叉树.手把手带你刷二叉树_纲领篇.T104;

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
    public int maxDepth(TreeNode root) {
        return getDepth(root);
    }

    // 动态规划思维
    public int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        // 后序位置
        return Math.max(leftDepth, rightDepth) + 1;
    }

    // 回溯思维
    int maxDepth = 0;
    int curDepth = 0;

    public void traverse(TreeNode root) {
        if (root == null) {
            maxDepth = Math.max(maxDepth, curDepth);
            return;
        }
        // 前序位置
        curDepth++;
        traverse(root.left);
        traverse(root.right);
        // 后序位置
        curDepth--;
    }

    public int maxDepth2(TreeNode root) {
        traverse(root);
        return maxDepth;
    }
}
