package leetcode;

import java.util.HashMap;

public class problem106 {
    /**
     * 根据一棵树的中序遍历与后序遍历构造二叉树。
     *
     * 注意:
     * 你可以假设树中没有重复的元素。
     *
     * 例如，给出
     *
     * 中序遍历 inorder = [9,3,15,20,7]
     * 后序遍历 postorder = [9,15,7,20,3]
     * 返回如下的二叉树：
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) return null;
        TreeNode root = new TreeNode(postorder[postorder.length -1]);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        root.left = buildTree(postorder, postorder.length - 1, map, 0, map.get(postorder[postorder.length -1])-1);
        root.right = buildTree(postorder, postorder.length - 1, map, map.get(postorder[postorder.length -1])+1, inorder.length-1);
        return root;
    }

    public TreeNode buildTree(int[] postorder, int preindex, HashMap<Integer, Integer> map, int start, int end) {
        if (start > end) return null;

        for (int i = preindex; i >= 0; i--) {
            int val = postorder[i];
            if (map.get(val) >= start && map.get(val) <= end) { // 这里表示这是当前子树的父节点
                TreeNode node = new TreeNode(val);
                node.left = buildTree(postorder, i, map, start, map.get(val)-1);
                node.right = buildTree(postorder, i, map, map.get(val)+1, end);
                return node;
            }
        }
        return null;
    }
}
