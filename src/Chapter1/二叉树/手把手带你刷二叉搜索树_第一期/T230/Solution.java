package Chapter1.二叉树.手把手带你刷二叉搜索树_第一期.T230;

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
    int cur = 0;
    int K;
    int ans;

    public int kthSmallest(TreeNode root, int k) {
        K = k;
        traverse(root);
        return ans;
    }

    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        cur++;
        if (cur == K) {
            ans = root.val;
            return;
        }
        traverse(root.right);
    }
}
