package leetcode.java;

public class interviewProblem0404 {

    public boolean isBalanced(TreeNode root) {
        int height = treeHeight(root);
        return height != -1;
    }

    public int treeHeight(TreeNode root) {
        int left = 0, right = 0;
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left != null) {
            left = treeHeight(root.left);
        }
        if (root.right != null) {
            right = treeHeight(root.right);
        }
        if (left == -1 || right == -1) {
            return -1;
        }
        int abs = Math.abs(left - right);
        return abs > 1? -1 : Math.max(left, right) + 1;
    }
}
