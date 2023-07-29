// 在 BST 中插入一个数
// 注意：BST 中一般不会插入已存在元素

package Chapter1.二叉树.手把手带你刷二叉搜索树_第二期.T701;

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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            // 插入
            root = new TreeNode(val);
        }
        // if (root.val == val)
        //     BST 中一般不会插入已存在元素
        if (root.val > val) {
            // 左子树
            root.left = insertIntoBST(root.left, val);
        } else if (root.val < val) {
            // 右子树
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
}
