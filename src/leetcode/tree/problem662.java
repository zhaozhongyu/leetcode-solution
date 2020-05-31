package leetcode.tree;

import java.util.LinkedList;
import java.util.Stack;

public class problem662 {
    /**
     * 给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。
     *
     * 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
     * */
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        LinkedList<TreeNode> list = new LinkedList<>();
        list.push(root);
        int width = 1;
        int num = 1; // 当前这层的剩余节点数
        int temp = 0; // 下一层
        while (!list.isEmpty()) {
            for (int i = 0; i < num; i++) {
                TreeNode node = list.pollFirst();
                if (temp != 0) {
                    if (node!= null && node.left != null)  {
                        list.addLast(node.left);
                    } else {
                        list.addLast(null);
                    }
                    if (node != null && node.right != null ) {
                        list.addLast(node.right);
                    } else {
                        list.addLast(null);
                    }
                    temp += 2;
                }
                else {
                    if (node != null && node.left != null) {
                        list.addLast(node.left);
                        temp ++;
                    }
                    if (node != null && node.right != null) {
                        list.addLast(node.right);
                        temp ++;
                    } else if (temp!= 0) {
                        list.addLast(null);
                        temp ++;
                    }
                }
            }
            while (!list.isEmpty() && list.peekLast() == null) {
                list.pollLast();
            }
            temp = list.size();
            width = Math.max(width, temp);
            num = temp;
            temp = 0;
        }
        return width;
    }

    public static void main(String[] args) {
        Integer [] nums = new Integer[]{1,3,2,5,3,null,9};
        TreeNode node = TreeNode.createTreeNode(nums);
        new problem662().widthOfBinaryTree(node);
    }
}
