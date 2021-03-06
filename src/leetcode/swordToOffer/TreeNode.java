package leetcode.swordToOffer;

import java.util.LinkedList;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

    public static TreeNode createTreeNode (Integer[] nums) {
        TreeNode root = new TreeNode(nums[0]);
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        for (int i = 1; i < nums.length; i+=2) {
            TreeNode node = list.poll();
            if (nums[i] != null) {
                node.left = new TreeNode(nums[i]);
                list.addLast(node.left);
            }
            if (i+1 < nums.length && nums[i+1] != null) {
                node.right = new TreeNode(nums[i+1]);
                list.addLast(node.right);
            }
        }
        return root;
    }
}
