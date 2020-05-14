package leetcode;

public class problem124 {

    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return root.val;
        int left = maxPathSum(root.left);
        int right = maxPathSum(root.right);

        if (root.val > 0) {
            return root.val + Math.max(0, left) + Math.max(0, right);
        } else {
            return Math.max(Math.max(left, right), left+right+root.val);
        }

    }

    public int PathSum(TreeNode node) {
        if (node == null) return 0;
        int left = PathSum(node.left);
        int right = PathSum(node.right);
        if (node.val > 0) {
            return node.val + Math.max(0, Math.max(left, right));
        }
        if (left + node.val > 0 || right + node.val > 0) {
            return Math.max(left + node.val, right + node.val);
        }
        return 0;
    }

    public static void main(String[] args) {
        Integer [] nums = new Integer[]{-10,9,20,null,null,15,7};
        TreeNode node = TreeNode.createTreeNode(nums);
        System.out.println(new problem124().maxPathSum(node));
    }
}
