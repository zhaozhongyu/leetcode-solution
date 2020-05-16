package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class problem102 {
//    public static void main(String[] args) {
//        Integer [] nums = new Integer[]{3,9,20,null,null,15,7};
//        TreeNode node = TreeNode.createTreeNode(nums);
//        new problem102().levelOrder(node);
//    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) return lists;
        LinkedList<TreeNode> nodes = new LinkedList<>();
        LinkedList<Integer> levels = new LinkedList<>();
        levels.add(0);
        nodes.add(root);
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.pollFirst();
            int level = levels.pollFirst();
            List<Integer> list;
            if (lists.size() > level) {
                list = lists.get(level);
            } else {
                list = new LinkedList<>();
                lists.add(list);
            }
            list.add(node.val);
            if (node.left != null) {
                nodes.add(node.left);
                levels.add(level+1);
            }
            if (node.right != null) {
                nodes.add(node.right);
                levels.add(level+1);
            }
        }
        return lists;
    }
}
