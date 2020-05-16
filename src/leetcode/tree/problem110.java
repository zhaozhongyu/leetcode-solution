package leetcode.tree;

public class problem110 {

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        if (left == Integer.MIN_VALUE || right == Integer.MIN_VALUE) return false;
        if (Math.abs(left - right) <=1 ) {
            return true;
        }
        return false;
    }

    public int getHeight(TreeNode node) {
        if (node == null) return 0;
        int left = getHeight(node.left);
        int right = getHeight(node.right);
        if (left == Integer.MIN_VALUE || right == Integer.MIN_VALUE || Math.abs(left-right) > 1) {
            return Integer.MIN_VALUE;
        }
        return Math.max(left, right) + 1;
    }

    public static void main(String [] args) {
        Integer[] nums = new Integer[]{1,2,null,3,null,4,null,5};
        TreeNode node = TreeNode.createTreeNode(nums);
        new problem110().isBalanced(node);
    }
}
