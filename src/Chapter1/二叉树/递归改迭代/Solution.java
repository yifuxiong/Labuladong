package Chapter1.二叉树.递归改迭代;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
     * 代码模板
     * */
//    private Stack<TreeNode> stk = new Stack<>();
//
//    public List<Integer> traverse(TreeNode root) {
//        pushLeftBranch(root);
//
//        while (!stk.isEmpty()) {
//            TreeNode p = stk.pop();
//            pushLeftBranch(p.right);
//        }
//    }
//
//    public void pushLeftBranch(TreeNode p) {
//        while (p != null) {
//            stk.push(p);
//            p = p.left;
//        }
//    }

    /*
     * 前序、中序、后序遍历位置插入
     * 如果 p 的左右子树都没有被遍历，那么现在对 p 进行操作就属于前序遍历代码。
     * 如果 p 的左子树被遍历过了，而右子树没有被遍历过，那么现在对 p 进行操作就属于中序遍历代码。
     * 如果 p 的左右子树都被遍历过了，那么现在对 p 进行操作就属于后序遍历代码。
     * */
//    private Stack<TreeNode> stk = new Stack<>();
//
//    public List<Integer> traverse(TreeNode root) {
//        pushLeftBranch(root);
//
//        while (!stk.isEmpty()) {
//            TreeNode p = stk.peek();
//
//            if (p 的左子树被遍历完了) {
//                /*******************/
//                /** 中序遍历代码位置 **/
//                /*******************/
//                // 去遍历 p 的右子树
//                pushLeftBranch(p.right);
//            }
//
//            if (p 的右子树被遍历完了) {
//                /*******************/
//                /** 后序遍历代码位置 **/
//                /*******************/
//                // 以 p 为根的树遍历完了，出栈
//                stk.pop();
//            }
//        }
//    }
//
//    private void pushLeftBranch(TreeNode p) {
//        while (p != null) {
//            /*******************/
//            /** 前序遍历代码位置 **/
//            /*******************/
//            stk.push(p);
//            p = p.left;
//        }
//    }

    /*
     * 如何判断 p 的左右子树到底被遍历过没有呢？
     * 我们只需要维护一个 visited 指针，
     * 指向「上一次遍历完成的根节点」，就可以判断 p 的左右子树遍历情况了
     * */
    // 模拟函数调用栈
//    private Stack<TreeNode> stk = new Stack<>();
//
//    // 左侧树枝一撸到底
//    private void pushLeftBranch(TreeNode p) {
//        while (p != null) {
//            /*******************/
//            /** 前序遍历代码位置 **/
//            /*******************/
//            stk.push(p);
//            p = p.left;
//        }
//    }
//
//    public List<Integer> traverse(TreeNode root) {
//        // 指向上一次遍历完的子树根节点
//        TreeNode visited = new TreeNode(-1);
//        // 开始遍历整棵树
//        pushLeftBranch(root);
//
//        while (!stk.isEmpty()) {
//            TreeNode p = stk.peek();
//
//            // p 的左子树被遍历完了，且右子树没有被遍历过
//            if ((p.left == null || p.left == visited)
//                    && p.right != visited) {
//                /*******************/
//                /** 中序遍历代码位置 **/
//                /*******************/
//                // 去遍历 p 的右子树
//                pushLeftBranch(p.right);
//            }
//            // p 的右子树被遍历完了
//            if (p.right == null || p.right == visited) {
//                /*******************/
//                /** 后序遍历代码位置 **/
//                /*******************/
//                // 以 p 为根的子树被遍历完了，出栈
//                // visited 指针指向 p
//                visited = stk.pop();
//            }
//        }
//    }

    /*
     * 实战代码
     * 后序遍历：递归转迭代
     * */
    private Stack<TreeNode> stk = new Stack<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postorder = new ArrayList<>();
        TreeNode visited = new TreeNode(-1);

        pushLeftBranch(root);
        while (!stk.isEmpty()) {
            TreeNode p = stk.peek();

            if ((p.left == null || p.left == visited) && p.right != visited) {
                pushLeftBranch(p.right);
            }

            if (p.right == null || p.right == visited) {
                // 后序遍历代码位置
                postorder.add(p.val);
                visited = stk.pop();
            }
        }
        return postorder;
    }

    private void pushLeftBranch(TreeNode p) {
        while (p != null) {
            stk.push(p);
            p = p.left;
        }
    }
}
