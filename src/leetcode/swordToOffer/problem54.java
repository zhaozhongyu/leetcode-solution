package leetcode.swordToOffer;

import java.util.Stack;

public class problem54 {
    /**
     * 给定一棵二叉搜索树，请找出其中第k大的节点。
     * */
    public int kthLargest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return 0;
        }
        stack.push(root);
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.right;
            } else {
                root = stack.pop();
                k--;
                if (k == 0) {
                    return root.val;
                }
                root = root.left;
            }
        }
        return root.val;
    }
}
