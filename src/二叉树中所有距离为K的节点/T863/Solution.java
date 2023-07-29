package 二叉树中所有距离为K的节点.T863;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode parent;

    TreeNode(int x) {
        val = x;
    }
}

// leetcode第863题
class Solution {
    // BFS
    List<Integer> res;
    Set<Integer> hashSet = new HashSet<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        res = new ArrayList<>();
        addParent(root, null);

        Deque<TreeNode> que = new ArrayDeque<>();
        que.offer(target);
        hashSet.add(target.val);
        int dist = 0;

        while (!que.isEmpty()) {
            dist++;
            int size = que.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = que.poll();
                if (dist - 1 == k) {
                    res.add(node.val);
                    hashSet.add(node.val);
                }
                if (node.left != null) {
                    if (!hashSet.contains(node.left.val)) {
                        que.offer(node.left);
                        hashSet.add(node.left.val);
                    }
                }
                if (node.right != null) {
                    if (!hashSet.contains(node.right.val)) {
                        que.offer(node.right);
                        hashSet.add(node.right.val);
                    }
                }
                if (node.parent != null) {
                    if (!hashSet.contains(node.parent.val)) {
                        que.offer(node.parent);
                        hashSet.add(node.parent.val);
                    }
                }
            }
        }
        return res;
    }

    public void addParent(TreeNode root, TreeNode parent) {
        root.parent = parent;
        if (root.left != null) {
            addParent(root.left, root);
        }
        if (root.right != null) {
            addParent(root.right, root);
        }
    }
}
