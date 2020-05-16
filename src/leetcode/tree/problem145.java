package leetcode.tree;

import javax.transaction.TransactionRequiredException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class problem145 {

    /**
     * 给定一个二叉树，返回它的 后序 遍历。
     *
     * 示例:
     *
     * 输入: [1,null,2,3]
     *    1
     *     \
     *      2
     *     /
     *    3
     *
     * 输出: [3,2,1]
     * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/binary-tree-postorder-traversal
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * */
    // 两种办法, 一种是先前序再倒装, 另一种是拆分后push进stack
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            TreeNode left = null;
            TreeNode right = null;
            if (node.left == null && node.right == null) {
                result.add(node.val);
            } else {
                left = node.left;
                right = node.right;
                node.left = null;
                node.right = null;
                stack.push(node);
            }
            if (right != null) {
                stack.push(right);
            }
            if (left != null) {
                stack.push(left);
            }
        }
        return result;
    }
}
