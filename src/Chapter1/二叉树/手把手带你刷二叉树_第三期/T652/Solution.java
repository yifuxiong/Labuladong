package Chapter1.二叉树.手把手带你刷二叉树_第三期.T652;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
    HashMap<String, Integer> memo;
    List<TreeNode> list;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        memo = new HashMap<>();
        list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        traverse(root);
        return list;
    }

    public String traverse(TreeNode root) {
        if (root == null) {
            return "#";
        }
        String leftStr = traverse(root.left);
        String rightStr = traverse(root.right);
        String subStr = leftStr + "," + rightStr + "," + root.val;

        int freq = memo.getOrDefault(subStr, 0);
        if (freq == 1) {
            list.add(root);
        }
        memo.put(subStr, freq + 1);

        return subStr;
    }
}
