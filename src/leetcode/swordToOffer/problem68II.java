package leetcode.swordToOffer;

import java.util.ArrayList;
import java.util.List;

public class problem68II {
    // 这个和1的区别是, 这个不是搜索树
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> listp = new ArrayList<>();
        List<TreeNode> listq = new ArrayList<>();
        findAncestor(root, p, listp);
        findAncestor(root, q, listq);
        TreeNode ret = root;
        int size = Math.min(listp.size(), listq.size());
        for (int i = 0; i < size; i++) {
            if (listp.get(i) == listq.get(i)) {
                ret = listp.get(i);
            } else {
                break;
            }
        }
        return ret;
    }

    public boolean findAncestor(TreeNode root, TreeNode target, List<TreeNode> list) {
        if (root == null) {
            return false;
        }
        list.add(root);
        if (root.val == target.val) {
            return true;
        }
        if (findAncestor(root.left, target, list)) {
            return true;
        }
        if (findAncestor(root.right, target, list)) {
            return true;
        }
        list.remove(list.size() - 1);
        return false;
    }

    public static void main(String[] args) {
        TreeNode node = TreeNode.createTreeNode(new Integer[]{3,5,1,6,2,0,8,null,null,7,4});
//        new problem68II().lowestCommonAncestor(node, new TreeNode(5), new TreeNode(4));
        problem68II p = new problem68II();
        List<TreeNode> list = new ArrayList<>();
        p.findAncestor(node, new TreeNode(4), list);
        System.out.println(list);
    }
}
