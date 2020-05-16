package leetcode.tree;

public class problem99 {
    public static void main(String[] args) {
        Integer [] nums = new Integer[]{3,1,4,null,null,2};
        TreeNode root = TreeNode.createTreeNode(nums);
        new problem99().recoverTree(root);
    }

    // 中序遍历的时候, 数字是严格按从小到大排序
    public void recoverTree(TreeNode root) {
        TreeNode[] treeNodes = new TreeNode[3];
        inorder(root, treeNodes);
        int temp = treeNodes[0].val;
        treeNodes[0].val = treeNodes[1].val;
        treeNodes[1].val = temp;
    }

    public void inorder (TreeNode root, TreeNode[] treeNodes) {
        if (root == null) return;
        inorder(root.left, treeNodes);
        if (treeNodes[2] != null) {
            if (treeNodes[2].val > root.val) {
                if (treeNodes[0] == null) {
                    treeNodes[0] = treeNodes[2];
                    treeNodes[1] = root;
                } else {
                    treeNodes[1] = root;
                }
            }
        }
        treeNodes[2] = root;
        inorder(root.right, treeNodes);
    }
}
