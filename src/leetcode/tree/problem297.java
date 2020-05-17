package leetcode.tree;

import java.util.LinkedList;
import java.util.Stack;

public class problem297 {

    /**
     * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
     *
     * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
     *
     * 示例: 
     *
     * 你可以将以下二叉树：
     *
     *     1
     *    / \
     *   2   3
     *      / \
     *     4   5
     *
     * 序列化为 "[1,2,3,null,null,4,5]"
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * */
    // Encodes a tree to a single string.
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
