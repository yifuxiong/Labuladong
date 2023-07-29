// 给你二叉搜索树的根节点 root ，该树中的两个节点的值被错误地交换。
// 请在不改变其结构的情况下，恢复这棵树。

package T99;

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

/*
 * 注意：题目说是只有2个节点的值被错误地交换。
 * 有且只有2个节点值交换才能用下面的方法。
 * */
public class Solution {
    // 上一个节点
    TreeNode prev = new TreeNode(Integer.MIN_VALUE);
    // 第一个最大值节点
    TreeNode firstMax = null;
    // 最后一个最小值节点
    TreeNode lastMin = null;

    public void recoverTree(TreeNode root) {
        dfs(root);
        if (firstMax != null && lastMin != null) {
            int temp = firstMax.val;
            firstMax.val = lastMin.val;
            lastMin.val = temp;
        }
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        if (node.val < prev.val) {
            // 第一个最大值节点没找到之前
            if (firstMax == null) {
                firstMax = prev;
            }
            lastMin = node;
        }
        prev = node;
        dfs(node.right);
    }
}
