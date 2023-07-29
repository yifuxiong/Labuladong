// 通过前序和中序遍历结果构造二叉树

package Chapter1.二叉树.手把手带你刷二叉树_第二期.T105;

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode build(int[] preorder, int pstart, int pend, int[] inorder, int istart, int iend) {
        if (pstart > pend){
            return null;
        }
        int rootVal = preorder[pstart];
        // 在中序遍历中找到 rootVal 的索引
        int index = istart;
        for (int i = istart; i <= iend; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }

        TreeNode root = new TreeNode(rootVal);
        root.left = build(preorder, pstart + 1, pstart + index - istart, inorder, istart, index - 1);
        root.right = build(preorder, pstart + 1 + index - istart, pend, inorder, index + 1, iend);
        return root;
    }
}
