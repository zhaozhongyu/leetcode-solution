package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class problem107 {

//    public static void main(String[] args) {
//        Integer [] nums = new Integer[]{3,9,20,null,null,15,7};
//        TreeNode node  = TreeNode.createTreeNode(nums);
//        new problem107().levelOrderBottom(node);
//    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> lists = new LinkedList<>();
        if (root == null) return lists;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int num = 1;
        int temp = 0;
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.pollFirst();
            list.add(node.val);
            if (node.left != null) {
                queue.addLast(node.left);
                temp ++;
            }
            if (node.right != null) {
                queue.addLast(node.right);
                temp ++;
            }
            num --;
            if (num == 0) {
                num = temp;
                temp = 0;
                lists.addFirst(list);
                list = new ArrayList<>();
            }
        }
        return lists;
    }
}
