/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var addTwoNumbers = function(l1, l2) {
    var n = l1.val + l2.val;
    var l, bool = 0;
    if(n >= 10) {
        bool = 1;
        l = new ListNode(n % 10);
    } else {
        bool = 0;
        l = new ListNode(n);
    }
    l1 = l1.next;
    l2 = l2.next;
    var result = l;
    while(l1 !== null && l2 !== null){
        n = l1.val + l2.val + bool;
        if(n >= 10) {
            bool = 1;
            l.next = new ListNode(n % 10);
        } else {
            bool = 0;
            l.next = new ListNode(n);
        }
        l1 = l1.next;
        l2 = l2.next;
        l = l.next;
    }
    while(l1 !== null){
        n = l1.val + bool;
        if(n >= 10) {
            bool = 1;
            l.next = new ListNode(n % 10);
        } else {
            bool = 0;
            l.next = new ListNode(n);
        }
        l1 = l1.next;
        l = l.next
    }
    while(l2 !== null){
        n = l2.val + bool;
        if(n >= 10) {
            bool = 1;
            l.next = new ListNode(n % 10);
        } else {
            bool = 0;
            l.next = new ListNode(n);
        }
        l2 = l2.next;
        l = l.next
    }
    if(bool === 1){
        l.next = new ListNode(1);
    }
    return result;
};
