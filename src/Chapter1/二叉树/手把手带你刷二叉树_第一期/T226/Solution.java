package Chapter1.二叉树.手把手带你刷二叉树_第一期.T226;

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
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
