package Chapter1.二叉树.手把手带你刷二叉树_第一期.T116;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

public class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        dfs(root.left, root.right);
        return root;
    }

    public void dfs(Node node1, Node node2) {
        if (node1 == null) {
            return;
        }
        node1.next = node2;

        dfs(node1.left, node1.right);
        dfs(node1.right, node2.left);
        dfs(node2.left, node2.right);
    }
}
