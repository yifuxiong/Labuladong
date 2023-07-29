package nowcode.二叉树_判断是不是完全二叉树;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

/*
对完全二叉树最重要的定义就是叶子节点只能出现在最下层和次下层，
所以我们想到可以使用层序遍历，只有次下层和最下层才有叶子节点，
其他层出现叶子节点就意味着不是完全二叉树。
step 1：先判断空树一定是完全二叉树。
step 2：初始化一个队列辅助层次遍历，将根节点加入。
step 3：逐渐从队列中弹出元素访问节点，如果遇到某个节点为空，进行标记，
代表到了完全二叉树的最下层，若是后续还有访问，则说明提前出现了叶子节点，
不符合完全二叉树的性质。
step 4：否则，继续加入左右子节点进入队列排队，等待访问。
*/
public class Solution {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // 是否到达最底层
        boolean flag = false;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                flag = true;
                // 必须要有continue，进入队列下一个节点
                continue;
            }

            if (flag) {
                return false;
            }

            queue.offer(node.left);
            queue.offer(node.right);
        }

        return true;
    }
}
