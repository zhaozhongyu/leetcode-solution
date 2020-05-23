package leetcode.tree;

import java.util.LinkedList;

public class problem513 {

    /**
     * 给定一个二叉树，在树的最后一行找到最左边的值。
     *
     * 示例 1:
     *
     * 输入:
     *
     *     2
     *    / \
     *   1   3
     *
     * 输出:
     * 1
     *  
     *
     * 示例 2:
     *
     * 输入:
     *
     *         1
     *        / \
     *       2   3
     *      /   / \
     *     4   5   6
     *        /
     *       7
     *
     * 输出:
     * 7
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-bottom-left-tree-value
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * */
    public int findBottomLeftValue(TreeNode root) {
        LinkedList<TreeNode> nodes = new LinkedList<>();
        int result = root.val;
        int num = 1;
        int temp = 0;
        boolean isFirst = true;
        nodes.add(root);
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.pollFirst();
            num --;
            if (isFirst) {
                isFirst = false;
                result = node.val; //第一个节点
            }
            if (node.left != null) {
                nodes.addLast(node.left);
                temp ++;
            }
            if (node.right != null) {
                nodes.addLast(node.right);
                temp++;
            }

            if (num == 0) { // 进入下一层
                num = temp;
                temp = 0;
                isFirst = true;
            }
        }
        return result;
    }



}
