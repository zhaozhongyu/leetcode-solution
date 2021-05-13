package leetcode.java;

import leetcode.swordToOffer.ListNode;

public class problem234 {

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        // 先用快慢指针, 定位到中间点
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (slow == null) {
            return true;
        }
        // 此时slow为中间点, 翻转slow后面的指向
        ListNode temp = slow.next, tempnext;
        while (temp != null) {
            tempnext = temp.next;
            temp.next = slow;
            slow = temp;
            temp = tempnext;
        }
        ListNode left = head, right = slow;
        while (left != null && right != null) {
            if (left.val != right.val) {
                return false;
            }
            if (left == right || left.next == right || right.next == left) {
                break;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

//    public static void main(String[] args) {
//        System.out.println(new problem234().isPalindrome(ListNode.createListNode(new int[]{1,2})));
//    }
}
