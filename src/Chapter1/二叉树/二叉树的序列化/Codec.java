package Chapter1.二叉树.二叉树的序列化;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        serializeDfs(root, sb);
        return sb.toString();
    }

    public void serializeDfs(TreeNode root, StringBuffer sb) {
        if (root == null) {
            sb.append("#").append(",");
            return;
        }
        sb.append(root.val).append(",");
        serializeDfs(root.left, sb);
        serializeDfs(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        List<String> list = new LinkedList<>(Arrays.asList(nodes));
        return deserializeDfs(list);
    }

    public TreeNode deserializeDfs(List<String> list){
        if (list.get(0).equals("#")){
            list.remove(list.get(0));  // 不要忘了这一句！
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        root.left = deserializeDfs(list);
        root.right = deserializeDfs(list);
        return root;
    }
}
