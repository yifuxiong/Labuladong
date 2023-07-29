// 通过后序和中序遍历结果构造二叉树

package Chapter1.二叉树.手把手带你刷二叉树_第二期.T106;

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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode build(int[] inorder, int istart, int iend, int[] postorder, int pstart, int pend) {
        if (pstart > pend) {
            return null;
        }
        int rootVal = postorder[pend];
        // 找到rootVal在中序遍历中的索引
        int index = istart;
        for (int i = istart + 1; i <= iend; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }

        TreeNode root = new TreeNode(rootVal);
        root.left = build(inorder, istart, index - 1, postorder, pstart, pend - (iend - index) - 1);
        root.right = build(inorder, index + 1, iend, postorder, pend - (iend - index), pend - 1);
        return root;
    }

    // 也可以先用哈希表先对rootVal在中序遍历的索引进行存储
}
