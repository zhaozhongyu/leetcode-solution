package leetcode.tree;

public class problem572 {

    /**
     * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
     * */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        return isSametree(s, t) ||
                isSubtree(s.left, t) ||
                isSubtree(s.right, t);
    }

    public boolean isSametree (TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.val != t.val) return false;
        return isSametree(s.left, t.left) && isSametree(s.right, t.right);
    }

    public static void main(String[] args ) {
        Integer[] s1 = new Integer[]{1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,2};
        Integer[] t1 = new Integer[]{1,null,1,null,1,null,1,null,1,null,1,2};
        TreeNode s = TreeNode.createTreeNode(s1);
        TreeNode t = TreeNode.createTreeNode(t1);
        new problem572().isSubtree(s, t);
    }
}
