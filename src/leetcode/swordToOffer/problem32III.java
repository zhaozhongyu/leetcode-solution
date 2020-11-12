package leetcode.swordToOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class problem32III {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) return lists;
        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        int level = 0;
        while (!nodes.isEmpty()) {
            List<Integer> list;
            if (lists.size() > level) {
                list = lists.get(level);
            } else {
                list = new LinkedList<>();
                lists.add(list);
            }
            int size = nodes.size();
            if (level % 2 == 0) { //left to right
                for (int i = size-1; i >= 0; i--) {
                    TreeNode node = nodes.get(i);
                    nodes.remove(i);
                    list.add(node.val);
                    if (node.left != null) nodes.add(node.left);
                    if (node.right != null) nodes.add(node.right);
                }
            } else {
                for (int i = size-1; i >= 0; i--) {
                    TreeNode node = nodes.get(i);
                    nodes.remove(i);
                    list.add(node.val);
                    if (node.right != null) nodes.add(node.right);
                    if (node.left != null ) nodes.add(node.left);

                }
            }
            level++;
        }
        return lists;
    }
}
