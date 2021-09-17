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
var maxLevelSum = function(root) {
  let level = 1;
  let list = [root];
  let max = root.val - 1;
  let maxlevel = 1;
  while (list.length) {
    let tmp = [];
    let sum = 0;
    while (list.length) {
      let node = list.pop();
      sum += node.val;
      node.left && tmp.push(node.left);
      node.right && tmp.push(node.right);
    }
    list = tmp;
    if (sum > max) {
      maxlevel = level;
      max = sum;
    }
    level++;
  }
  return maxlevel;
};

const treenode = require('./TreeNode')
const root = treenode.createTreeNode([989, null, 10250, 98693, -89388, null, null, null, -32127])
maxLevelSum(root)