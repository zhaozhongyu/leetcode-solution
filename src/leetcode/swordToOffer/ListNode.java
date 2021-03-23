package leetcode.swordToOffer;

public class ListNode {
   int val;
   ListNode next;
   ListNode(int x) { val = x; }
   static ListNode createListNode(int[] nums) {
      ListNode head = new ListNode(-1);
      ListNode temp = head;
      for (int i = 0; i < nums.length; i++) {
         temp.next = new ListNode(nums[i]);
         temp = temp.next;
      }
      return head.next;
   }
}
