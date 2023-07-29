package YongJ.Z字遍历二叉树;

import java.util.*;

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
    public List<Integer> function(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int level = 1;

        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();

            if (level % 2 != 0) {
                Deque<Integer> stack = new ArrayDeque<>();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if (node == null) {
                        continue;
                    }
                    stack.push(node.val);
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
                while (!stack.isEmpty()) {
                    ans.add(stack.pop());
                }
            } else {
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if (node == null) {
                        continue;
                    }
                    ans.add(node.val);
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }
        }
        return ans;
    }

    public TreeNode buildTree(Integer[] nums) {
        List<TreeNode> nodes = new LinkedList<>();
        for (Integer num : nums) {
            if (num == null) {
                nodes.add(null);
            } else {
                nodes.add(new TreeNode(num));
            }
        }

        for (int i = 0; i < nodes.size() / 2; i++) {
            TreeNode tmpRoot = nodes.get(i);
            if (tmpRoot == null) {
                continue;
            }
            tmpRoot.left = nodes.get(i * 2 + 1);
            if (i * 2 + 2 < nodes.size()) {
                tmpRoot.right = nodes.get(i * 2 + 2);
            }
        }
        return nodes.get(0);
    }

    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        inOrder(root.left);
        inOrder(root.right);
    }

    public static void main(String[] args) {
        Integer[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

        Solution solut = new Solution();
        TreeNode root = solut.buildTree(nums);
        // solut.inOrder(root);
        System.out.println(solut.function(root));
    }
}
