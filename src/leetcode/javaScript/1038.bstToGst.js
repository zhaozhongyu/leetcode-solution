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
 * @return {TreeNode}
 */
var sum = 0;
var bstToGst = function (root) {
  sum = 0;
  postOrder(root);
  return root;
};

var postOrder = function (node) {
  if (node == null) return;
  postOrder(node.right);
  let temp = node.val;
  node.val = node.val + sum;
  sum += temp;
  postOrder(node.left);
}
