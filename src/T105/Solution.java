// 给定一棵树的前序遍历 preorder 与中序遍历  inorder。
// 请构造二叉树并返回其根节点。

package T105;

import java.util.HashMap;

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
    HashMap<Integer, Integer> hashMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        hashMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            hashMap.put(inorder[i], i);
        }

        TreeNode root = createTree(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
        return root;
    }

    public TreeNode createTree(int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end) {
        if (p_start > p_end) {
            return null;
        }

        // 前序遍历是MLR，每次取p_start都是一个父节点
        int rootVal = preorder[p_start];
        TreeNode tmpRoot = new TreeNode(rootVal);
        // 这个值在中序遍历中的索引
        int index = hashMap.get(rootVal);

        // 这里根据前序遍历是MLR，中序遍历是LMR，找到两棵树中的左子树部分
        tmpRoot.left = createTree(preorder, p_start + 1, p_start + (index - i_start),
                inorder, i_start, index - 1);

        // 找到两棵树的右子树的部分
        tmpRoot.right = createTree(preorder, p_start + 1 + (index - i_start), p_end,
                inorder, index + 1, i_end);

        return tmpRoot;
    }
}
