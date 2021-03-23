package leetcode.tree;

import java.util.ArrayList;

public class problem897 {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */

    // 简单做法: 中序转前序
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) return root;
        ArrayList<Integer> arrayList = new ArrayList<>();
        midOrder2PreOrder(root, arrayList);
        TreeNode treeRoot = new TreeNode(arrayList.get(0));
        TreeNode temp = treeRoot;
        for (int i = 1; i < arrayList.size(); i++) {
            TreeNode node = new TreeNode(arrayList.get(i));
            temp.right = node;
            temp = node;
        }
        return treeRoot;
    }

    public void midOrder2PreOrder(TreeNode node, ArrayList<Integer> arrayList) {
        if (node == null) {
            return;
        }
        midOrder2PreOrder(node.left, arrayList);
        arrayList.add(node.val);
        midOrder2PreOrder(node.right, arrayList);
    }

}
