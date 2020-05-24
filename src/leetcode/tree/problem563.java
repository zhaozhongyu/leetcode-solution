package leetcode.tree;

import java.util.HashMap;

public class problem563 {

    /**
     * 给定一个二叉树，计算整个树的坡度。
     *
     * 一个树的节点的坡度定义即为，该节点左子树的结点之和和右子树结点之和的差的绝对值。空结点的的坡度是0。
     *
     * 整个树的坡度就是其所有节点的坡度之和。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/binary-tree-tilt
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * */
    int result = 0;
    public int findTilt(TreeNode root) {
        HashMap<TreeNode, Integer> map = new HashMap<>();

        findNodeSum(root, map);
        return result;
    }

    public int findNodeSum (TreeNode node, HashMap<TreeNode, Integer> map) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return node.val;
        if (map.containsKey(node)) return map.get(node);
        int left = findNodeSum(node.left, map);
        int right = findNodeSum(node.right, map);
        int r = left + right + node.val;
        result += Math.abs(left - right); // result 存放坡度
        if (node.left != null) map.remove(node.left);
        if (node.right != null) map.remove(node.right);
        map.put(node, r); // map存放的是和
        return r;
    }
}
