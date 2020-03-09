package leetcode;

import java.util.ArrayList;
import java.util.List;

public class problem82 {
    public ListNode deleteDuplicates(ListNode head) {
        List<Integer> list = new ArrayList<>();
        if (head == null) return head;
        while (head != null && head.next != null) {
            if (head.val != head.next.val) {
                list.add(head.val);

            } else {
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }

            }
            head = head.next;
        }
        ListNode result = new ListNode(-1);
        ListNode node = result;
        for (int i = 0; i < list.size(); i++) {
            node.next = new ListNode(list.get(i));
            node = node.next;
        }
        node.next = head;
        return result.next;
    }


    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}



