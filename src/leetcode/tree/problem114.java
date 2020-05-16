package leetcode.tree;

import java.util.Stack;

public class problem114 {

    /**
     * 给定一个二叉树，原地将它展开为链表。
     *
     * 例如，给定二叉树
     *
     *     1
     *    / \
     *   2   5
     *  / \   \
     * 3   4   6
     * 将其展开为：
     *
     * 1
     *  \
     *   2
     *    \
     *     3
     *      \
     *       4
     *        \
     *         5
     *          \
     *           6
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * */
    public void flatten(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return;
        Stack<TreeNode> stack = new Stack<>();
        if (root.right != null) stack.push(root.right);
        if (root.left != null) stack.push(root.left);
        root.left = null;
        TreeNode temp = root;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            temp.right = node;
            temp = node;
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left == null) {
                continue;
            }
            stack.push(node.left);
            node.right = node.left;
            node.left = null;
        }
    }

//    public static void main(String[] args ) {
//        Integer[] nums = new Integer[]{1,2,5,3,4,null,6};
//        TreeNode node = TreeNode.createTreeNode(nums);
//        new problem114().flatten(node);
//        System.out.print(node);
//    }
}
