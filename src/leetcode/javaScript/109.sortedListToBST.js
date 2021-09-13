/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * 前序遍历表示的链表重新构造成二叉树, 优化: 先获取到列表长度之后, 根据当前位置进行建树操作
 * @param {ListNode} head
 * @return {TreeNode}
 */
var sortedListToBST = function (head) {
  let r = listToBST(head, null);
  return r;
};

var listToBST = function (left, right) {
  let mid = getMid(left, right);
  let ret = null;
  if (mid !== null && mid !== undefined) {
    ret = { val: mid.val };
    ret.left = listToBST(left, mid);
    ret.right = listToBST(mid.next, right);
  }
  return ret;
}

// [left, right)
var getMid = function (left, right) {
  if (!left || left === right) {
    return null;
  }
  if (left.next === right) {
    return left;
  }
  let step = mid = left;
  while (step && step.next && step !== right && step.next !== right) {
    mid = mid.next;
    step = step.next.next;
  }
  return mid;
}


// 
list = [-10, -3, 0, 5, 9]
const h = { val: list[0] }
let tmp = h;
for (let i = 1; i < list.length; i++) {
  tmp.next = { val: list[i] }
  tmp = tmp.next;
}
sortedListToBST(h);