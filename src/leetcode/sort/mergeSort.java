package leetcode.sort;

import leetcode.swordToOffer.ListNode;

/**
 * 归并排序
 * */
public class mergeSort {


    // 链表归并排序, 递归排序
    public ListNode sortList(ListNode head) {
        head = mergeSort(head);
        return head;
    }

    public ListNode mergeSort(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        ListNode slow = node, fast = node.next;
        // 用快慢指针找到中间点
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode node2 = slow.next;
        slow.next = null;
        ListNode node1 = node;
        node1 = mergeSort(node1);
        node2 = mergeSort(node2);
        ListNode ret = merge(node1, node2);
        return ret;
    }

    // 合并两节链表
    public ListNode merge(ListNode node1, ListNode node2) {
        ListNode node = new ListNode(-1);
        ListNode root = node;
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                node.next = node1;
                node = node.next;
                node1 = node1.next;
            } else {
                node.next = node2;
                node = node.next;
                node2 = node2.next;
            }
        }
        if (node1 != null) {
            node.next = node1;
        }
        if (node2 != null) {
            node.next = node2;
        }
        return root.next;
    }
}
