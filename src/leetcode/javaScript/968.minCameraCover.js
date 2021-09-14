/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * 后序遍历
 * @param {TreeNode} root
 * @return {number}
 */
var count = 0;
var minCameraCover = function(root) {
  count = 0;
  if (root == null) return 0;
  if (postOrder(root) == 2) count++;
  return count;
};

// 0：该节点安装了监视器 1：该节点可观，但没有安装监视器 2：该节点未被观察
var postOrder = function (node) {
  if (node === null) {
    return 1;
  }
  let left = postOrder(node.left), right = postOrder(node.right);
  if (left === 2 || right === 2) {
    // 有子节点没有观察, 需要安装
    count++;
    return 0;
  }
  if (left === 0 || right === 0) {
    // 白嫖子节点的
    return 1;
  } else {
    return 2;
  }
}