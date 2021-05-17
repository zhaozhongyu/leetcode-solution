package leetcode.sort;

import leetcode.swordToOffer.ListNode;

// 用于测试是否排序正确
public class testSort {

    public static boolean isSorted(ListNode node) {
        if (node == null) return true;
        int val = node.val;
        while (node.next != null) {
            node = node.next;
            if (node.val < val) {
                return false;
            }
            val = node.val;
        }
        return true;
    }
}
