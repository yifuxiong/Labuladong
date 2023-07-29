package Chapter1.二叉树.手把手带你刷二叉树_第二期.T654;

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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode root = build(nums, 0, nums.length - 1);
        return root;
    }

    public TreeNode build(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int maxValue = nums[start];
        int maxIndex = start;
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] > maxValue) {
                maxValue = nums[i];
                maxIndex = i;
            }
        }
        // 必须是前序遍历
        // 只有先把 root 构造了，才能继续构造它的子树
        TreeNode root = new TreeNode(maxValue);
        root.left = build(nums, start, maxIndex - 1);
        root.right = build(nums, maxIndex + 1, end);
        return root;
    }
}
