/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root1
 * @param {TreeNode} root2
 * @return {boolean}
 */
var flipEquiv = function (root1, root2) {
  if (root1 === null && root2 === null) {
    return true;
  }
  if ((!root1) || (!root2) || (root1.val !== root2.val)) {
    return false;
  }
  // 可交换
  if (((root1.left === null && root2.right === null) || (root1.left && root2.right && root1.left.val === root2.right.val)) &&
    ((root1.right === null && root2.left === null) || (root1.right && root2.left && root1.right.val === root2.left.val)) ) {
    const temp = root2.left;
    root2.left = root2.right;
    root2.right = temp;
  } else if (((root1.left === null && root2.left === null) || (root1.left && root2.left && root1.left.val === root2.left.val)) &&
  ((root1.right === null && root2.right === null) || (root1.right && root2.right && root1.right.val === root2.right.val))) {
    // 左右一致无需交换
  } else {
    return false;
  }
  return flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
};