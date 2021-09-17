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
 * @return {number[][]}
 */
var verticalTraversal = function(root) {
  let ret = {}
  traversal(root, 0, 0, ret);
  let keys = Object.keys(ret).sort((a, b) => a - b);
  let list = [];
  for (let key of keys) {
    let rowrets = [];
    let vals = ret[key];
    let valkeys = Object.keys(vals).sort((a, b) => a - b);
    for (let vk of valkeys) {
      let rowvals = vals[vk].sort((a, b) => a - b);
      rowrets = rowrets.concat(rowvals);
    }
    list.push(rowrets);
  }
  return list;
};


var traversal = function (node, row, col, ret) {
  if (!node) {
    return;
  }
  if (!ret[col]) {
    ret[col] = {};
  }
  if (!ret[col][row]) {
    ret[col][row] = [];
  }
  ret[col][row].push(node.val);
  if (node.left) {
    traversal(node.left, row + 1, col - 1, ret);
  }
  if (node.right) {
    traversal(node.right, row + 1, col + 1, ret);
  }
}

const treenode = require('./TreeNode')
const root = treenode.createTreeNode([0,7,1,null,10,2,null,11,null,3,14,13,null,null,4,null,null,null,null,12,5,null,null,6,9,8]);
t