package YongJ.Z字遍历二叉树;

import java.util.*;

// 二叉树层次Z型遍历完整版
public class Solut {
    public TreeNode createTree(Integer[] nums) {
        List<TreeNode> nodes = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != null) {
                nodes.add(new TreeNode(nums[i]));
            } else {
                nodes.add(null);
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

    public void levelOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        Deque<TreeNode> que = new ArrayDeque<>();
        que.offer(root);

        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = que.poll();
                System.out.print(node.val + " ");
                if (node.left != null) {
                    que.offer(node.left);
                }
                if (node.right != null) {
                    que.offer(node.right);
                }
            }
            System.out.println();
        }
    }

    public List<List<Integer>> ZPrint(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> que = new ArrayDeque<>();
        que.offer(root);

        int level = 0;
        while (!que.isEmpty()) {
            level++;
            int size = que.size();
            ArrayList<Integer> ans = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = que.poll();
                ans.add(node.val);
                if (node.left != null) {
                    que.offer(node.left);
                }
                if (node.right != null) {
                    que.offer(node.right);
                }
            }
            if (level % 2 == 0) {
                Collections.reverse(ans);
            }
            res.add(ans);
        }
        return res;
    }

    public List<List<Integer>> zTraverse(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Deque<TreeNode> que = new ArrayDeque<>();
        que.offer(root);

        int level = 0;
        while (!que.isEmpty()) {
            level++;
            int size = que.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = que.poll();
                temp.add(node.val);
                if (node.left != null) {
                    que.offer(node.left);
                }
                if (node.right != null) {
                    que.offer(node.right);
                }
            }
            if (level % 2 == 0) {
                Collections.reverse(temp);
            }
            ans.add(temp);
        }
        return ans;
    }

    public static void main(String[] args) {
        Integer[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

        Solut solut = new Solut();
        TreeNode root = solut.createTree(nums);
        solut.levelOrder(root);

        List<List<Integer>> res = solut.ZPrint(root);
        System.out.println(res);
    }
}
