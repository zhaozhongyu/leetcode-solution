package leetcode;

import java.util.*;

public class problem94 {
    /**
     * 给定一个二叉树，返回它的中序 遍历。
     *
     * 示例:
     *
     * 输入: [1,null,2,3]
     *    1
     *     \
     *      2
     *     /
     *    3
     *
     * 输出: [1,3,2]
     * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
     * */
    // 递归用法Recursive
    public List<Integer> inorderTraversalRecursive (TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        result.addAll(inorderTraversal(root.left));
        result.add(root.val);
        result.addAll(inorderTraversal(root.right));
        return result;
    }

    // 迭代解法
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            if (treeNode.left == null && treeNode.right == null) {
                result.add(treeNode.val);
                continue;
            }
            if (treeNode.right != null) {
                stack.push(treeNode.right);
            }
            stack.push(new TreeNode(treeNode.val));
            if (treeNode.left != null) {
                stack.push(treeNode.left);
            }
        }
        return result;
    }
}
