package leetcode.swordToOffer;

import java.util.ArrayList;

public class problem26 {
    /**
     * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
     *
     * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
     *
     * 例如:
     * 给定的树 A:
     *
     *      3
     *     / \
     *    4   5
     *   / \
     *  1   2
     * 给定的树 B：
     *
     *    4 
     *   /
     *  1
     * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
     *
     * 示例 1：
     *
     * 输入：A = [1,2,3], B = [3,1]
     * 输出：false
     * 示例 2：
     *
     * 输入：A = [3,4,5,1,2], B = [4,1]
     * 输出：true
     * */
    public static boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;
        boolean res = true;
        if (A.val == B.val) {
            ArrayList<TreeNode> nodes = new ArrayList<>();
            nodes.add(A);
            nodes.add(B);
            while (!nodes.isEmpty()) {
                TreeNode tempA = nodes.remove(0);
                TreeNode tempB = nodes.remove(0);
                if (tempB == null) {
                } else if (tempA == null) {
                    res = false;
                    break;
                } else if (tempA.val == tempB.val) {
                    nodes.add(tempA.left);
                    nodes.add(tempB.left);
                    nodes.add(tempA.right);
                    nodes.add(tempB.right);
                } else {
                    res = false;
                    break;
                }
            }
        } else {
            res = false;
        }
        return res || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    public static void main(String[] args) {
        Integer [] nums1 = new Integer[]{1,0,1,-4,3};
        Integer [] nums2 = new Integer[]{1,-4};
        TreeNode A = TreeNode.createTreeNode(nums1);
        TreeNode B = TreeNode.createTreeNode(nums2);
        isSubStructure(A, B);
    }
}
