package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class problem83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode node = head;
        while(node != null && node.next != null) {
            while(node.next != null && node.val == node.next.val) {
                node.next = node.next.next;
            }
            node = node.next;
        }
        return head;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}

