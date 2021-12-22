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
var maxPathSum = function (root) {
  // 使用max记录当前遍历到的最大值
  let max = (root && root.val) || 0;
  // 返回值是经过当前节点的一边的最大值
  function getMaxPath(root) {

    let left = 0;
    let right = 0;
    if (root.left) {
      left = Math.max(0, getMaxPath(root.left));
    }
    if (root.right) {
      right = Math.max(0, getMaxPath(root.right));
    }
    max = Math.max(max, root.val + left + right);
    return Math.max(root.val + left, root.val + right);
  }
  if (root) {
    getMaxPath(root);
  }
  return max;
};

root = { val: -1, left: { val: 5,  }, right: null };