// 通过后序和前序遍历结果构造二叉树

package Chapter1.二叉树.手把手带你刷二叉树_第二期.T889;

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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return build(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode build(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd) {
        if (preStart > preEnd) {
            return null;
        }
        if (preStart == preEnd){
            return new TreeNode(preorder[preStart]);
        }

        int rootVal = preorder[preStart];
        // 主要是确定leftVal的索引
        int leftVal = preorder[preStart + 1];
        // 前序遍历左子树在后序遍历中的位置
        int index = postStart;
        for (int i = postStart; i <= postEnd; i++) {
            if (postorder[i] == leftVal) {
                index = i;
                break;
            }
        }

        TreeNode root = new TreeNode(rootVal);
        root.left = build(preorder, preStart + 1, preStart + index - postStart + 1, postorder, postStart, index);
        root.right = build(preorder, preStart + index - postStart + 2, preEnd, postorder, index + 1, postEnd - 1);
        return root;
    }
}
