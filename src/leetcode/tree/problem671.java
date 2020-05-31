package leetcode.tree;

import java.util.Stack;

public class problem671 {

    /**
     *给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么这个节点的值不大于它的子节点的值。 
     *
     * 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
     * */
    public int findSecondMinimumValue(TreeNode root) {
        int result = -1;
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.val > root.val && (result == -1 || result > node.val)) {
                result = node.val;
            }
            if (node.left != null) {
                stack.push(node.left);
                stack.push(node.right);
            }
        }
        return result;
    }
}
