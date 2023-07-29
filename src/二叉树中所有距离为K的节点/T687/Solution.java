package 二叉树中所有距离为K的节点.T687;

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

class Solution {
    int res = 0;

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return res;
    }

    public int dfs(TreeNode root) {
        // 注意这个dfs的功能，返回左或右的同值最长路径长度
        if (root == null) {
            return 0;
        }

        int leftVal = dfs(root.left);
        int rightVal = dfs(root.right);

        int left = 0, right = 0;
        if (root.left != null && root.val == root.left.val) {
            left = leftVal + 1;
        }
        if (root.right != null && root.val == root.right.val) {
            right = rightVal + 1;
        }
        res = Math.max(res, left + right);

        // 所以这里是 return 左或右最长的路径长度
        return Math.max(left, right);
    }
}
