package leetcode.tree;

import java.util.LinkedList;
import java.util.List;

public class problem637 {

    public List<Double> averageOfLevels(TreeNode root) {
        LinkedList<Double> list = new LinkedList<>();
        if (root == null) return list;
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.addLast(root);
        int num = 1;
        while (!treeNodes.isEmpty()) {
            double count = 0;
            for (int i = num; i > 0; i--) {
                TreeNode node = treeNodes.pollFirst();
                count += node.val;
                if (node.left != null) treeNodes.addLast(node.left);
                if (node.right != null) treeNodes.addLast(node.right);
            }
            double res = count / num;
            list.addLast(res);
            num = treeNodes.size();
        }
        return list;
    }

    public static void main(String[] args) {
        Integer [] nums = new Integer[]{3,9,20,15,7};
        TreeNode node = TreeNode.createTreeNode(nums);
        new problem637().averageOfLevels(node);
    }
}
