/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 * https://leetcode-cn.com/problems/partition-list/
 */
/**
 * @param {ListNode} head
 * @param {number} x
 * @return {ListNode}
 */
var partition = function(head, x) {
  let left = right = null;
  prenode = { next: head };
  let temp = prenode;
  while (temp && temp.next) {
    if (temp.next.val >= x) {
      left = right = temp;
      break;
    }
    temp = temp.next;
  }
  while (right && right.next) {
    if (right.next.val < x) {
      let ltmp = left.next;
      left.next = right.next;
      right.next = right.next.next;
      left.next.next = ltmp;
      left = left.next;
    } else {
      right = right.next;
    }
  }
  return prenode.next;
};

head = [1, 4, 3, 2, 5, 2]
const h = { val: head[0] }
let tmp = h;
for (let i = 1; i < head.length; i++) {
  tmp.next = { val: head[i] }
  tmp = tmp.next;
}
console.warn(partition(h, 3));
