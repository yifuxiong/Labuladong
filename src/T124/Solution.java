package T124;

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
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }

    public int dfs(TreeNode root) {
        // 终止条件
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, dfs(root.left));
        int right = Math.max(0, dfs(root.right));

        // 后序遍历代码位置

        // 左中右
        int lmr = root.val + left + right;
        // 左中，中右较大值
        int ret = root.val + Math.max(left, right);
        // 更新最大值
        ans = Math.max(ans, Math.max(lmr, ret));
        return ret;
    }

    public static void main(String[] args) {

    }
}
