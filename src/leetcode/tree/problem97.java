package leetcode.tree;


public class problem97 {
//    public static void main(String[] args) {
//        Integer [] nums = new Integer[]{3,1,5,0,2,4,6,null,null,null,3};
//        TreeNode node = TreeNode.createTreeNode(nums);
//        System.out.print(new problem97().isValidBST(node));
//
//    }
    // 中序遍历法
    public boolean isValidBST1(TreeNode root) {
        Integer[] n = new Integer[1];
        n[0] = null;
        return inorder(root, n);
    }

    public boolean inorder (TreeNode root, Integer[] n) {
        if (root == null) return true;
        if (!inorder(root.left, n)) {
            return false;
        }
        if (n[0] != null && n[0] >= root.val) {
            return false;
        }
        n[0] = root.val;
        if (!inorder(root.right, n)) {
            return false;
        }
        return true;
    }

    // 递归法
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.right != null &&
                !validRight(root.right, root.val) ||
                        !isValidBST(root.right)) {
            return false;
        }

        if (root.left != null && !validLeft(root.left, root.val) || !isValidBST(root.left)) {
            return false;
        }
        return true;
    }

    public boolean validLeft (TreeNode root, int val) {
        if (root == null) {
            return true;
        }
        if (root.val >= val) {
            return false;
        }
        if (root.right != null) {
            return validLeft(root.right, val);
        }
        return true;
    }

    public boolean validRight (TreeNode root, int val) {
        if (root == null) {
            return true;
        }
        if (root.val <= val) {
            return false;
        }
        if (root.left != null) {
            return validRight(root.left, val);
        }
        return true;
    }


}
