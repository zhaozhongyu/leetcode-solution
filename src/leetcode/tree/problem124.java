package leetcode.tree;

public class problem124 {

    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return root.val;
        int[] result = new int[2];
        result[0] = Integer.MIN_VALUE;
        result[1] = Integer.MIN_VALUE;
        int left = PathSum(root.left, result);
        int right = PathSum(root.right, result);
        if (left == 0 && right == 0) return Math.max(result[0],Math.max(result[1], root.val)); // 单个节点
        int temp = 0;
        if (root.val > 0) {
            temp = root.val + Math.max(0, left) + Math.max(0, right);
        } else {
            temp = Math.max(Math.max(left, right), left+right+root.val); // 左边或右边
        }
        return Math.max(result[0],Math.max(result[1], temp));
    }

    // 返回值不会小于0
    public int PathSum(TreeNode node, int[] result) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) {
            result[1] = Math.max(result[1], node.val);
            return Math.max(node.val, 0); // 不带node
        }
        int left = PathSum(node.left, result);
        int right = PathSum(node.right, result);
        int temp = node.val;
        if (left > 0) {
            temp += left;
        }
        if (right > 0) {
            temp += right;
        }
        result[0] = Math.max(result[0], temp); // 不经过root时的最大值
        if (node.val > 0) { //返回中只有单边加上node, 或者node, 或不带node
            return Math.max(Math.max(left, right) + node.val, node.val);
        } else {
            return Math.max(Math.max(left, right) + node.val, 0);
        }

    }

    public static void main(String[] args) {
        Integer [] nums = new Integer[]{1,-2,-3,1,3,-2,null,-1};
        TreeNode node = TreeNode.createTreeNode(nums);
        System.out.println(new problem124().maxPathSum(node));
    }
}
