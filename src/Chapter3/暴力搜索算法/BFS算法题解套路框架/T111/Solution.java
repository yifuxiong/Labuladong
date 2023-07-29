package Chapter3.暴力搜索算法.BFS算法题解套路框架.T111;

import java.util.ArrayDeque;
import java.util.Deque;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    public int minDepth(TreeNode root) {
        return dfs(root);
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null) {
            return dfs(root.right) + 1;
        }
        if (root.right == null) {
            return dfs(root.left) + 1;
        }
        return Math.min(dfs(root.left), dfs(root.right)) + 1;
    }

    // BFS
    public int minDepth2(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        if (root == null) {
            return 0;
        }
        queue.offer(root);
        int depth = 0;

        while (!queue.isEmpty()) {
            depth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode tmpRoot = queue.poll();

                if (tmpRoot.left == null && tmpRoot.right == null) {
                    return depth;
                }
                if (tmpRoot.left != null) {
                    queue.offer(tmpRoot.left);
                }
                if (tmpRoot.right != null) {
                    queue.offer(tmpRoot.right);
                }
            }
        }
        return depth;
    }
}
