/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {string} traversal
 * @return {TreeNode}
 */
var recoverFromPreorder = function (traversal) {
  let list = traversal.split('-');
  const root = { val: list[0], left: null, right: null };
  let rightindex = list.length;
  for (let i = list.length - 1; i > 1; i--) {
    if (list[i] !== '' && list[i - 1] !== '') {
      rightindex = i;
      break;
    }
  }
  const left = list.slice(1, rightindex);
  root.left = recoverFromPreorderWithLevel(left, 1);
  if (rightindex !== list.length) {
    const right = list.splice(rightindex);
    root.right = recoverFromPreorderWithLevel(right, 1);
  }
  return root;
};

var recoverFromPreorderWithLevel = function (traversal, level) {
  if (traversal.length === 0) {
    return null;
  }
  const root = { val: traversal[0], left: null, right: null };
  if (traversal.length === 1) {
    return root;
  }
  let newtraversal = traversal.slice(1 + level);
  let left = newtraversal, right = '';
  for (let i = 1; i < newtraversal.length; ) {
    if (newtraversal[i] === '') {
      if (newtraversal[i + level] !== '') {
        left = newtraversal.slice(0, i);
        right = newtraversal.slice(i + level);
        break;
      }
      for (let j = i + 1; j < newtraversal.length; j++) {
        if (newtraversal[j] !== '') {
          i = j;
          break;
        }
      }
    } else {
      i++;
    }
  }
  root.left = recoverFromPreorderWithLevel(left, level + 1);
  root.right = recoverFromPreorderWithLevel(right, level + 1);
  return root;
}

const treeNode = require('./TreeNode');
const node = recoverFromPreorder("1-401--349---90--88");
treeNode.printTreeNode(node)