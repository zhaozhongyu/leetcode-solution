package leetcode.tree;

public class problem538 {

    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        postOrder(root);
        return root;
    }

    public void postOrder (TreeNode node) {
        if (node == null) return;
        postOrder(node.right);
        int temp = node.val;
        node.val = node.val + sum;
        sum += temp;
        postOrder(node.left);
    }

    public static void main(String[] args) {
        Integer[] nums = new Integer[]{5,2,13};
        TreeNode node = TreeNode.createTreeNode(nums);
        new problem538().convertBST(node);
    }
}
