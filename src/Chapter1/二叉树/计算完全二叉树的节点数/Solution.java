package Chapter1.二叉树.计算完全二叉树的节点数;

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
    // 普通二叉树
    public int countNodes1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    // 满二叉树
    public int countNodes2(TreeNode root) {
        int h = 0;
        while (root != null) {
            root = root.left;
            h++;
        }
        return (int) Math.pow(2, h) - 1;
    }

    // 完全二叉树：上面两种的结合
    public int countNodes(TreeNode root) {
        TreeNode l = root, r = root;
        int hl = 0, hr = 0;
        while (l != null) {
            hl++;
            l = l.left;
        }
        while (r != null) {
            hr++;
            r = r.right;
        }
        if (hl == hr) {
            // 满二叉树
            return (int) Math.pow(2, hr) - 1;
        } else {
            // 这样递归，总有一边是满二叉树
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }
}
