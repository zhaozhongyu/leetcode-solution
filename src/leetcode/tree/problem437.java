package leetcode.tree;

import java.util.Stack;

public class problem437 {

    /**
     * 给定一个二叉树，它的每个结点都存放着一个整数值。
     *
     * 找出路径和等于给定数值的路径总数。
     *
     * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
     *
     * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
     *
     * 示例：
     *
     * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
     *
     *       10
     *      /  \
     *     5   -3
     *    / \    \
     *   3   2   11
     *  / \   \
     * 3  -2   1
     *
     * 返回 3。和等于 8 的路径有:
     *
     * 1.  5 -> 3
     * 2.  5 -> 2 -> 1
     * 3.  -3 -> 11
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/path-sum-iii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * */
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int result = 0;
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result += getPathSum(node, sum);
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
        return result;
    }

    public int getPathSum(TreeNode node, int sum) {
        if (node == null) return 0;
        int result = 0;
        if (node.val == sum )  result ++;
        int left = getPathSum(node.left, sum - node.val);
        int right = getPathSum(node.right, sum - node.val);
        return result+left+right;
    }

    public static void main(String[] args ){
        Integer[] nums = new Integer[]{1,-2,-3,1,3,-2,null,-1};
        TreeNode root = TreeNode.createTreeNode(nums);
        new problem437().pathSum(root, -1);
    }
}
