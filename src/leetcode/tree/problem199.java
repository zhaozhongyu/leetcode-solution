package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class problem199 {

    /**
     * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
     *
     * 示例:
     *
     * 输入: [1,2,3,null,5,null,4]
     * 输出: [1, 3, 4]
     * 解释:
     *
     *    1            <---
     *  /   \
     * 2     3         <---
     *  \     \
     *   5     4       <---
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/binary-tree-right-side-view
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * */
    public List<Integer> rightSideView(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<TreeNode> temp = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.peekLast();
            list.add(node.val);
            // 把下一层的非null孩子节点加进来
            while(! stack.isEmpty()) {
                node = stack.pollFirst();
                if (node.left != null) {
                    temp.addLast(node.left);
                }
                if (node.right != null) {
                    temp.addLast(node.right);
                }
            }
            stack = temp;
            temp = new LinkedList<>();
        }
        return list;
    }

//    public static void main(String[] args) {
//        Integer[] nums = new Integer[]{1,2,3,null,5,null,4};
//        TreeNode node = TreeNode.createTreeNode(nums);
//        new problem199().rightSideView(node);
//    }
}
