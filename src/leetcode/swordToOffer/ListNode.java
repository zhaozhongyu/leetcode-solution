package leetcode.swordToOffer;

public class ListNode {
   public int val;
   public ListNode next;
   ListNode(int x) { val = x; }
   ListNode(int val, ListNode next) { this.val = val; this.next = next; }
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
