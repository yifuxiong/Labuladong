package Chapter1.二叉树.美团面试官_你对后序遍历一无所知;

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

    /*
     * res[0] -> is BST 0:false, 1:true
     * res[1] -> minVal
     * res[2] -> maxVal
     * res[3] -> curTree sumVal
     * */
    int maxVal = 0;

    public int maxSumBST(TreeNode root) {
        traverse(root);
        return maxVal;
    }

    public int[] traverse(TreeNode root) {
        if (root == null) {
            return new int[]{
                    // 注意res[1]是MAX_VALUE，res[2]是MIN_VALUE
                    1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0
            };
        }

        int[] left = traverse(root.left);
        int[] right = traverse(root.right);

        int[] res = new int[4];
        if (left[0] == 1 && right[0] == 1 && root.val > left[2] && root.val < right[1]) {
            res[0] = 1;
            res[1] = Math.min(left[1], root.val);
            res[2] = Math.max(right[2], root.val);
            res[3] = root.val + left[3] + right[3];
            maxVal = Math.max(maxVal, res[3]);
        } else {
            res[0] = 0;
        }
        return res;
    }
}
