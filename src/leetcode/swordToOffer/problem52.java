package leetcode.swordToOffer;

public class problem52 {

    // 先移动到最后, 再从后往前比对
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        ListNode temp = null;
        ListNode tempnext = null;
        while (nodeA.next != null) {
            temp = nodeA.next;
            if (temp.next != null) {
                tempnext = temp.next;
                temp.next = nodeA;
                nodeA = tempnext;
            } else {
                temp.next = nodeA;
                nodeA = temp;
            }
        }
        return null;
    }
}
