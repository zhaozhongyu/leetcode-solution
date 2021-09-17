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
 * @return {number}
 */
var maxAncestorDiff = function (root) {
  if (!root) return 0;
  return maxAncestorDiffEx(root, root.val, root.val);
};

// 返回[max, min]
var maxAncestorDiffEx = function(root, max, min) {
  if (!root) {
    return max - min;
  }
  max = Math.max(root.val, max);
  min = Math.min(root.val, min);
  let left = maxAncestorDiffEx(root.left, max, min);
  let right = maxAncestorDiffEx(root.right, max, min);
  return Math.max(right, left);
};