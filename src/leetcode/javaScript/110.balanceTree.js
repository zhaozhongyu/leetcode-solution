/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */


var isBalanced = function (root) {
  let height = treeHeight(root)
  if (height === -1) {
    return false;
  } else {
    return true;
  }
};

var treeHeight = function (root) {
  let left = 0, right = 0;
  if (!root) {
    return 0;
  }
  if (!root.left && !root.right) {
    return 1;
  }
  if (root.left) {
    left = treeHeight(root.left) + 1;
  }
  if (root.right) {
    right = treeHeight(root.right) + 1;
  }
  if (left === -1 || right === -1) {
    return -1;
  }
  let abs = Math.abs(left - right);
  return abs > 1 ? -1 : Math.max(left, right);
}