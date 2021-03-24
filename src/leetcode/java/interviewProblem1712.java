package leetcode.java;

import java.util.ArrayList;
import java.util.List;

public class interviewProblem1712 {
    public TreeNode convertBiNode(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<TreeNode> list = new ArrayList<>();
        preOrder(root, list);
        for (int i = 0; i < list.size(); i++) {
            TreeNode node = list.get(i);
            node.left = null;
            if (i == list.size() - 1) {
                node.right = null;
            } else {
                node.right = list.get(i + 1);
            }
        }

        return list.get(0);
    }

    public void preOrder(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return ;
        }
        preOrder(root.left, list);
        list.add(root);
        preOrder(root.right, list);
    }
}
