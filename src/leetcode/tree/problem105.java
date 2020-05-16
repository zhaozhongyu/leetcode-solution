package leetcode.tree;

import java.util.HashMap;

public class problem105 {

    /**
     * 根据一棵树的前序遍历与中序遍历构造二叉树。
     *
     * 注意:
     * 你可以假设树中没有重复的元素。
     *
     * 例如，给出
     *
     * 前序遍历 preorder = [3,9,20,15,7]
     * 中序遍历 inorder = [9,3,15,20,7]
     * 返回如下的二叉树：
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * */

    // 先从前序数组中找到根节点, 然后将中序数组分为左右两半, 此时再递归执行
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        root.left = buildTree(preorder, 1, map, 0, map.get(preorder[0])-1);
        root.right = buildTree(preorder, 1, map, map.get(preorder[0])+1, inorder.length-1);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int preindex, HashMap<Integer, Integer> map, int start, int end) {
        if (start > end) return null;

        for (int i = preindex; i < preorder.length; i++) {
            int val = preorder[i];
            if (map.get(val) >= start && map.get(val) <= end) { // 这里表示这是当前子树的父节点
                TreeNode node = new TreeNode(val);
                node.left = buildTree(preorder, i, map, start, map.get(val)-1);
                node.right = buildTree(preorder, i, map, map.get(val)+1, end);
                return node;
            }
        }
        return null;
    }

//    public static void  main(String[] args) {
//        int[] preorder = new int[]{3,9,20,15,7};
//        int[] inorder = new int[]{9,3,15,20,7};
//        TreeNode node = new problem105().buildTree(preorder, inorder);
//        System.out.print(node);
//    }
}
