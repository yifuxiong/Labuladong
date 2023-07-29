package Chapter1.二叉树.最近公共祖先.T236;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    // 后序遍历
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null && right == null) {
            return null;  // 第1种情况
        }
        if (left == null) {
            return right;  // 第3种情况
        }
        if (right == null){
            return left;  // 第4种情况
        }
        // if (left != null && right != null)  第2种情况
        return root;
    }
}
