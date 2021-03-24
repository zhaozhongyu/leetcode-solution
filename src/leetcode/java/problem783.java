package leetcode.java;

public class problem783 {
    public int minDiffInBST(TreeNode root) {
        int[] nums = {Integer.MAX_VALUE, Integer.MAX_VALUE};
        inOrder(root, nums);
        return nums[1];
    }

    public void inOrder(TreeNode root, int[] nums) {
        if (root == null) {
            return ;
        }
        inOrder(root.left, nums);
        if (Math.abs(root.val - nums[0]) < nums[1]) {
            nums[1] = Math.abs(nums[0]  - root.val);
        }
        nums[0] = root.val;
        inOrder(root.right, nums);
    }
}
