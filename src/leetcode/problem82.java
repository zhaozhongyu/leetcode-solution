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

    public static void main(String[] args) {
        int[] nums = new int[]{1,1};
        ListNode node = new ListNode(-1);
        ListNode head = node;
        for (int i = 0; i < nums.length; i++) {
            node.next = new ListNode(nums[i]);
            node = node.next;
        }
        System.out.print(new problem82().deleteDuplicates(head.next));
    }
}

class ListNode {
     int val;
     ListNode next;
    ListNode(int x) { val = x; }
 }