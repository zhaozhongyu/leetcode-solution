package leetcode.tree;

import java.util.Stack;

public class problem450 {

    /**
     * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
     *
     * 一般来说，删除节点可分为两个步骤：
     *
     * 首先找到需要删除的节点；
     * 如果找到了，删除它。
     * 说明： 要求算法时间复杂度为 O(h)，h 为树的高度。
     *
     * 示例:
     *
     * root = [5,3,6,2,4,null,7]
     * key = 3
     *
     *     5
     *    / \
     *   3   6
     *  / \   \
     * 2   4   7
     *
     * 给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
     *
     * 一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
     *
     *     5
     *    / \
     *   4   6
     *  /     \
     * 2       7
     *
     * 另一个正确答案是 [5,2,6,null,4,null,7]。
     *
     *     5
     *    / \
     *   2   6
     *    \   \
     *     4   7
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/delete-node-in-a-bst
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * */
    // 1. 如果右侧有子节点, 则用右侧最小节点的值替换为这个值, 并且删除替换的节点
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key && root.left == null && root.right == null) {
            return null;
        }
        TreeNode[] parent = new TreeNode[1];
        TreeNode node = findNode(root, key, parent);
        if (node == null) return root;
        if (node.left == null && node.right == null) { // 如果是叶子节点, 则不作处理
            if (parent[0].left == node) {
                parent[0].left = null;
            } else {
                parent[0].right = null;
            }
        }
        else if (node.right != null) {
            if (node.right.left == null) { // 如果右孩子没有左孩子, 则直接替换
                node.val = node.right.val;
                node.right = node.right.right;
            } else {
                TreeNode node1 = findReplace(node);
                node.val = node1.val;
            }
        }
        else { // 此时node.right == null, node.left != null
            if (node.left.right == null) {
                node.val = node.left.val;
                node.left = node.left.left;
            } else {
                TreeNode node1 = findReplace(node);
                node.val = node1.val;
            }
        }
        return root;
    }

    // 除非节点为root节点, 否则返回找到节点的父节点
    public TreeNode findNode (TreeNode node, int key, TreeNode[] parent) {
        if (node == null) return null;
        if (node.val == key) return node;
        parent[0] = node;
        if (node.val < key) {
            return findNode(node.right, key, parent);
        } else {
            return findNode(node.left, key, parent);
        }
    }

    // 查找下一个最小值, 或者下一个最大值
    public TreeNode findReplace (TreeNode node) {
        if (node.left == null && node.right == null) return null;
        TreeNode temp = null;
        if (node.right != null) {
            node = node.right;
            while (node.left != null) {
                temp = node;
                node = node.left;
            }
            temp.left = node.right;
            return node;
        }
        node = node.left;
        while (node.right != null) {
            temp = node;
            node = node.right;
        }
        temp.right = node.left;
        return node;
    }

}
