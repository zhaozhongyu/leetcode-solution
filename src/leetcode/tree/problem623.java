package leetcode.tree;

import java.util.LinkedList;

public class problem623 {

    /**
     * 给定一个二叉树，根节点为第1层，深度为 1。在其第 d 层追加一行值为 v 的节点。
     *
     * 添加规则：给定一个深度值 d （正整数），针对深度为 d-1 层的每一非空节点 N，为 N 创建两个值为 v 的左子树和右子树。
     *
     * 将 N 原先的左子树，连接为新节点 v 的左子树；将 N 原先的右子树，连接为新节点 v 的右子树。
     *
     * 如果 d 的值为 1，深度 d - 1 不存在，则创建一个新的根节点 v，原先的整棵树将作为 v 的左子树。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/add-one-row-to-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * */
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        }
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.push(root);
        int level = 1;
        int num = 1;
        while (!treeNodes.isEmpty()) {
            if (level == d - 1) {
                for (int i = num; i > 0; i--) {
                    TreeNode node = treeNodes.pollFirst();
                    TreeNode left = new TreeNode(v);
                    TreeNode right = new TreeNode(v);
                    left.left = node.left;
                    right.right = node.right;
                    node.left = left;
                    node.right = right;
                }
                return root;
            }
            for (int i = num; i > 0; i--) {
                TreeNode node = treeNodes.pollFirst();
                if (node.left != null) {
                    treeNodes.addLast(node.left);
                }
                if (node.right != null) {
                    treeNodes.addLast(node.right);
                }
            }
            level ++;
            num = treeNodes.size(); // 下一层的大小
        }
        return root;
    }
//[5,3,1,null,null,4,null,null,2]
//        2
//        4


}
