package leetcode;

import java.util.Stack;

public class problem112 {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> nodesums = new Stack<>();
        stack.push(root);
        nodesums.push(0);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int nodesum = nodesums.pop() + node.val;
            if (node.left == null && node.right == null) {
                if (nodesum == sum) {
                    return true;
                }
                continue;
            }
            if (node.left != null) {
                stack.push(node.left);
                nodesums.push(nodesum);
            }
            if (node.right != null) {
                stack.push(node.right);
                nodesums.push(nodesum);
            }
        }
        return false;
    }

//    public static void main(String[] args) {
//        Integer[] nums = new Integer[]{5,4,8,11,null,13,4,7,2,null,null,null,1};
//        TreeNode node = TreeNode.createTreeNode(nums);
//        System.out.println(new problem112().hasPathSum(node, 22));
//    }
}
