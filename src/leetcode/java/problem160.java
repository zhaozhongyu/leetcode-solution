package leetcode.java;

import leetcode.swordToOffer.ListNode;

public class problem160 {
    // 快慢指针另一个版本
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pointa = headA;
        ListNode pointb = headB;
        while (pointa != pointb) {
            if (pointa == null) {
                pointa = headB;
            } else {
                pointa = pointa.next;
            }
            if (pointb == null) {
                pointb = headA;
            } else {
                pointb = pointb.next;
            }
        }
        return pointa;
    }
}
