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
 * @param {number} limit
 * @return {TreeNode}
 */
var sufficientSubset = function(root, limit) {
  let needDelete = sufficientSubsetEx(root, limit, 0);
  if (needDelete) {
    return null;
  }
  return root;
};

// 返回是否该删除
var sufficientSubsetEx = function(root, limit, sum) {
  sum += root.val;
  let hasChild = !!(root.left || root.right);
  if (root.left) {
    let left = sufficientSubsetEx(root.left, limit, sum);
    if (left) {
      root.left = null;
    }
  }
  if (root.right) {
    let right = sufficientSubsetEx(root.right, limit, sum);
    if (right) {
      root.right = null;
    }
  }
  // 当前变成了叶节点
  if (!root.left && !root.right) {
    if (hasChild) {
      return true;
    } else if (sum < limit) {
      return true;
    }
  }
  return false;
};

const treenode = require('./TreeNode')
const root = treenode.createTreeNode([5,-6,-6]);
const ret = sufficientSubset(root, 1);
treenode.printTreeNode(ret);