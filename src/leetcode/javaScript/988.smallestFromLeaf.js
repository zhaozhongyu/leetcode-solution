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
 * @return {string}
 */
var charCode = 'abcdefghijklmnopqrstuvwxyz';
var smallestFromLeaf = function(root) {
  return order(root)[0];
};

// 返回值是一个列表, 内部是前n个字母都一致的值
var order = function (root) {
  const char = charCode[root.val];
  if (!root.left && !root.right) {
    return [char];
  }
  let leftlist = [], rightlist = [];
  if (root.left) {
    leftlist = order(root.left).map((val) => val + char);
  }
  if (root.right) {
    rightlist = order(root.right).map((val) => val + char);
  }
  let list = (leftlist.concat(rightlist)).sort();
  // 清理一下返回列表
  let first = list[0];
  let ret = [first];
  for (let i = 1; i < list.length; i++) {
    if (list[i].startsWith(first)) {
      ret.push(list[i]);
    } else {
      break;
    }
  }
  return ret;
}

const treeNode = require('./TreeNode');
const root = treeNode.createTreeNode([25,1,null,0,0,1,null,null,null,0]);
smallestFromLeaf(root);