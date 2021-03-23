package leetcode.swordToOffer;

import java.util.ArrayList;
import java.util.List;

public class problem68I {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > q.val) {
            TreeNode tmp = q;
            q = p;
            p = tmp;
        }
        while (root != null) {
            if (root.val >= p.val && root.val <= q.val) {
                return root;
            }
            if (root.val >= p.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return root;
    }

    public void findAncestor (TreeNode node, TreeNode sub, List<TreeNode> list) {
        list.add(node);
        if (node.val == sub.val) {
            return;
        }
        if (node.val > sub.val) {
            findAncestor(node.left, sub, list);
        } else {
            findAncestor(node.right, sub, list);
        }
    }
}
