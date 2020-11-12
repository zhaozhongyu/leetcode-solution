package leetcode.swordToOffer;

import java.util.ArrayList;
import java.util.LinkedList;

public class problem33 {

    /**
     * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
     *
     *  
     *
     * 参考以下这颗二叉搜索树：
     *
     *      5
     *     / \
     *    2   6
     *   / \
     *  1   3
     * 示例 1：
     *
     * 输入: [1,6,3,2,5]
     * 输出: false
     * 示例 2：
     *
     * 输入: [1,3,2,6,5]
     * 输出: true
     * */
    // 二叉搜索树的中序遍历的性质是从小到大排序
    // 后序转中序后, 再校验
    // 转中序的方法: 递归, 最后一个值是它的根节点
    public boolean verifyPostorder(int[] postorder) {
        return verify(postorder, 0, postorder.length - 1);
    }

    public boolean verify(int[] postorder, int left, int right) {
        if (left >= right) return true;
        int rootval = postorder[right];
        int mid = left;
        for (int i = left; i < right; i++) {
            // 此时i 右边的值都是rootval的右子树, 左边都是左子树
            if (postorder[i] > rootval) {
                for (int j = i + 1; j < right; j++) {
                    if (postorder[j] < rootval) {
                        return false;
                    }
                }
                mid = i;
            }
        }
        return verify(postorder, left, mid) && verify(postorder, mid, right - 1);
    }
}
