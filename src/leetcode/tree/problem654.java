package leetcode.tree;

public class problem654 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0 ) return null;
        TreeNode node = new TreeNode(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            node = insert(node, nums[i]);
        }
        return node;
    }

    public TreeNode insert (TreeNode node, int n ) {
        if (node.val > n) {
            if (node.right != null) {
                node.right = insert(node.right, n);
            } else {
                node.right = new TreeNode(n);
            }
            return node;
        } else {
            TreeNode node1 = new TreeNode(n);
            node1.left = node;
            return node1;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,6,0,5};
        new problem654().constructMaximumBinaryTree(nums);
    }
}
