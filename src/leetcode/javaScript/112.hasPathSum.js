/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @param {number} targetSum
 * @return {boolean}
 */
// 递归方式
var hasPathSum = function(root, targetSum) {
  if (!root) {
    return false;
  }
  if (isLeaf(root)) {
    if (root.val === targetSum) {
      return true;
    } else {
      return false;
    }
  }
  let res = false;
  if (root.left) {
    res = hasPathSum(root.left, targetSum - root.val);
  }
  if (!res && root.right) {
    res = hasPathSum(root.right, targetSum - root.val);
  }
  return res;
};


function isLeaf(node) {
  return node.left === null && node.right === null;
}