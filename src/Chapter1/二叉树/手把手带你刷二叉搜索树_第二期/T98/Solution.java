// 判断 BST 的合法性
// 注意有坑！

package Chapter1.二叉树.手把手带你刷二叉搜索树_第二期.T98;

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
    public boolean isValidBST(TreeNode root) {
        return dfs(root, null, null);
    }

    public boolean dfs(TreeNode root, TreeNode minNode, TreeNode maxNode) {
        if (root == null) {
            return true;
        }
        if (minNode != null && root.val <= minNode.val) {
            return false;
        }
        if (minNode != null && root.val >= maxNode.val) {
            return false;
        }
        // 限定左子树的最大值是 root.val，右子树的最小值是 root.val
        return dfs(root.left, minNode, root) && dfs(root.right, root, maxNode);
    }
}
