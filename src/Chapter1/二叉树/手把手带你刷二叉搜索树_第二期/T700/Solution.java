// 在 BST 中搜索元素

package Chapter1.二叉树.手把手带你刷二叉搜索树_第二期.T700;

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
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null){
            return null;
        }
        if (root.val == val){
            return root;
        }else if (root.val < val){
            return searchBST(root.right, val);
        }else{
            return searchBST(root.left, val);
        }
    }
}
