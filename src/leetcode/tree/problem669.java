package leetcode.tree;

public class problem669 {

    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return root;
        if (root.val < L) {
            return trimBST(root.right, L, R);
        }
        if (root.val > R) {
            return trimBST(root.left, L, R);
        }
        if (root.left != null && root.left.val < L) {
            root.left = trimBST(root.left, L, R);;
        } else {
            trimBST(root.left, L, R);
        }
        if (root.right != null && root.right.val > R) {
            root.right = trimBST(root.right, L, R);;
        } else {
            trimBST(root.right, L, R);
        }
        return root;
    }
}
