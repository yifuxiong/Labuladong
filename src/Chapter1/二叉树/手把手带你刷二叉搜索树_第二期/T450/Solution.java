// 在 BST 中删除一个数
// 1.左右子树都为空：直接删
// 2.左右子树有一个为空：用不为空的子树替代当前节点
// 3.左右子树都不为空：寻找右子树中的最小值节点，删除这个节点，并用这个节点替换当前节点

package Chapter1.二叉树.手把手带你刷二叉搜索树_第二期.T450;

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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null){
            return null;
        }
        if (root.val == key) {
            // 找到，删除
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }

            // 获得右子树最小的节点
            TreeNode minNode = getMin(root);
            // 删除右子树最小的节点
            root.right = deleteNode(root.right, minNode.val);
            // 用右子树最小的节点替换 root 节点
            minNode.left = root.left;
            minNode.right = root.right;
            root = minNode;
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    public TreeNode getMin(TreeNode root) {
        // BST 最左边的就是最小的
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}
