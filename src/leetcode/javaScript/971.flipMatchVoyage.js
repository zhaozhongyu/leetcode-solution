/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * 这个题目里的前序遍历值, 意思是不会输出空节点的null值
 * @param {TreeNode} root
 * @param {number[]} voyage
 * @return {number[]}
 */
var ret = [];
var flipMatchVoyage = function (root, voyage) {
  ret = [];
  flipTree(root, voyage);
  return ret;
};

var flipTree = function (root, voyage) {
  if (!root) {
    return ;
  }
  if (root.val !== voyage[0]) {
    return ret = [-1];
  }
  if (ret.length === 1 && ret[0] === -1) {
    return;
  }
  if (root.left) {
    if (root.left.val === voyage[1]) {
      // 无需交换
    } else if (root.left.val !== voyage[1] && root.right && root.right.val === voyage[1]) {
      // 左右反了, 必须要交换
      const temp = root.left;
      root.left = root.right;
      root.right = temp;
      ret.push(root.val);
      console.warn(root.val);
    } else {
      // 无法交换
      return ret = [-1];
    }
    if (root.right) {
      let index = voyage.findIndex(val => root.right.val === val);
      flipTree(root.left, voyage.slice(1, index));
      flipTree(root.right, voyage.slice(index));
    } else {
      flipTree(root.left, voyage.slice(1));
    }
  } else if (root.right) {
    flipTree(root.right, voyage.slice(1));
  }
}

const treeNode = require('./TreeNode');
let root = treeNode.createTreeNode([1,2,3]);
let r = flipMatchVoyage(root, [1, 3, 2])
console.log(r);