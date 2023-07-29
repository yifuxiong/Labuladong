package Chapter1.二叉树.手把手带你刷二叉树_纲领篇.T543;

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
    // 这个解法正确，但是运行时间很长
    // 因为我们使用的是双重递归
    int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null){
            return 0;
        }
        diameterOfBinaryTree(root.left);
        diameterOfBinaryTree(root.right);

        int leftDiameter = getDepth(root.left);
        int rihgtDiameter = getDepth(root.right);
        maxDiameter = Math.max(maxDiameter, leftDiameter + rihgtDiameter);

        return maxDiameter;
    }

    public int getDepth(TreeNode root){
        if (root == null){
            return 0;
        }
        int leftDiameter = getDepth(root.left);
        int rightDiameter = getDepth(root.right);
        return Math.max(leftDiameter, rightDiameter) + 1;
    }

    // 如果优化呢？
    // 我们使用后序递归，把计算【直径】的逻辑放在后序位置
    // 准确说是放在maxDepth的后序位置
    int res = 0;
    public int maxDepth(TreeNode root){
        if (root == null){
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        int diameter = leftDepth + rightDepth;
        res = Math.max(res, diameter);

        return 1 + Math.max(leftDepth, rightDepth);
    }
}
