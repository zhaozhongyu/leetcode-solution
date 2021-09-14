/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
const treeNode = require('./TreeNode');
/**
 * 前序优先遍历即可
 * @param {TreeNode} root
 * @return {boolean}
 */
var hasNullLeft = false;
var isCompleteTree = function (root) {
  let treelevel = -1, node = root;
  hasNullLeft = false;
  while (node) {
    node = node.left;
    treelevel++;
  }
  let ret = isCompleteTreeByLevel(root, 0, treelevel);
  return ret;
};

var isCompleteTreeByLevel = function (root, level, treelevel) {
  if (!root) {
    if (level > treelevel) {
    } else if (level === treelevel) {
      hasNullLeft = true;
    } else {
      return false;
    }
    return true;
  }
  if (level > treelevel && root) {
    return false;
  }
  if (level === treelevel && hasNullLeft) {
    return false;
  }
  return isCompleteTreeByLevel(root.left, level + 1, treelevel) && isCompleteTreeByLevel(root.right, level + 1, treelevel);
}

var root = treeNode.createTreeNode([1,null, 2,]);
isCompleteTree(root);