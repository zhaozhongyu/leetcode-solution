package leetcode.tree;

import java.util.LinkedList;

public class problem449 {

    public String serialize(TreeNode root) {
        // 前序优先遍历
        LinkedList<TreeNode> list = new LinkedList<>();
        list.push(root);
        StringBuffer sb = new StringBuffer();
        while (!list.isEmpty()) {
            TreeNode node = list.pollFirst();
            if (node == null) {
                sb.append("n,");
                continue;
            } else {
                sb.append(node.val);
                sb.append(",");
            }
            list.addLast(node.left);
            list.addLast(node.right);
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strings = data.split(",");
        if (strings[0].equals("n")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(strings[0]));
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        for (int i = 1; i < strings.length; i+=2) {
            TreeNode node = list.poll();
            if (!strings[i].equals("n")) {
                node.left = new TreeNode(Integer.parseInt(strings[i]));
                list.addLast(node.left);
            }
            if (i+1 < strings.length && !strings[i+1].equals("n")) {
                node.right = new TreeNode(Integer.parseInt(strings[i+1]));
                list.addLast(node.right);
            }
        }
        return root;
    }
}
