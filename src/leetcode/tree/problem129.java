package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class problem129 {

    /**
     * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
     *
     * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
     *
     * 计算从根到叶子节点生成的所有数字之和。
     *
     * 说明: 叶子节点是指没有子节点的节点。
     *
     * 示例 1:
     *
     * 输入: [1,2,3]
     *     1
     *    / \
     *   2   3
     * 输出: 25
     * 解释:
     * 从根到叶子节点路径 1->2 代表数字 12.
     * 从根到叶子节点路径 1->3 代表数字 13.
     * 因此，数字总和 = 12 + 13 = 25.
     * 示例 2:
     *
     * 输入: [4,9,0,5,1]
     *     4
     *    / \
     *   9   0
     *  / \
     * 5   1
     * 输出: 1026
     * 解释:
     * 从根到叶子节点路径 4->9->5 代表数字 495.
     * 从根到叶子节点路径 4->9->1 代表数字 491.
     * 从根到叶子节点路径 4->0 代表数字 40.
     * 因此，数字总和 = 495 + 491 + 40 = 1026.
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/sum-root-to-leaf-numbers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * */
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return root.val;
        ArrayList<String> list = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        sb.append(root.val);
        getNumbers(root.left, list, sb);
        sb = new StringBuffer();
        sb.append(root.val);
        getNumbers(root.right, list, sb);
        int result = 0;
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            result += Integer.parseInt(str);
        }
        return result;
    }

    public void getNumbers(TreeNode node, List<String> list, StringBuffer sb) {
        if (node == null) return ;
        sb.append(node.val);
        if (node.left == null && node.right == null) {
            list.add(sb.toString());
            return ;
        }
        StringBuffer sb1 = new StringBuffer(sb);
        getNumbers(node.left, list, sb1);
        StringBuffer sb2 = new StringBuffer(sb);
        getNumbers(node.right, list, sb2);
    }

//    public static void main(String[] args) {
//        Integer[] nums = new Integer[]{4,9,0,5,1};
//        TreeNode root = TreeNode.createTreeNode(nums);
//        new problem129().sumNumbers(root);
//    }

}
