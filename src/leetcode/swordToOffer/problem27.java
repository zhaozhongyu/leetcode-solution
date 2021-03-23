package leetcode.swordToOffer;

import java.util.ArrayList;
import java.util.LinkedList;

public class problem27 {
    /**
     * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
     *
     * 例如输入：
     *
     *      4
     *    /   \
     *   2     7
     *  / \   / \
     * 1   3 6   9
     * 镜像输出：
     *
     *      4
     *    /   \
     *   7     2
     *  / \   / \
     * 9   6 3   1
     *
     *  
     *
     * 示例 1：
     *
     * 输入：root = [4,2,7,1,3,6,9]
     * 输出：[4,7,2,9,6,3,1]
     * */
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return root;
        TreeNode node = root.right;
        root.right = root.left;
        root.left = node;
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.add(root.left);
        linkedList.add(root.right);
        while (!linkedList.isEmpty()) {
            node = linkedList.pop();
            if (node == null) {
                continue;
            }
            TreeNode temp = node.right;
            node.right = node.left;
            node.left = temp;
            linkedList.add(node.right);
            linkedList.add(node.left);
        }
        return root;
    }
}
