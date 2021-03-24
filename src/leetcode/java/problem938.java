package leetcode.java;

public class problem938 {
    public int rangeSumBST(TreeNode root, int low, int high) {
        int sum = 0;
        if (root == null) {
            return sum;
        }
        if (root.val <= high && root.val >= low) {
            sum += root.val;
            sum += rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
        } else if (root.val > high) {
            sum += rangeSumBST(root.left, low, high);
        } else {
            sum += rangeSumBST(root.right, low, high);
        }
        return sum;
    }
}
