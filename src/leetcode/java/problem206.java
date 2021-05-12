package leetcode.java;

import leetcode.swordToOffer.ListNode;

public class problem206 {

    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode cur = head, last = null;
        while (true) {
            if (cur.next == null) {
                cur.next = last;
                break;
            }
            ListNode tmp = cur.next;
            cur.next = last;
            last = cur;
            cur = tmp;
        }
        return cur;

    }
}
