/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * 中序遍历解决问题, 
 * 存在左右子节点的时候, 需要左还是右, 从底部开始可以确定
 * @param {TreeNode} root
 * @return {number}
 */
var distributeCoins = function(root) {
  let [moveCount, ] = distributeCoinsEx(root, 0, 0);
  return moveCount;
};

// 返回值第一个代表当前移动的次数, 第二个代表缺口, 允许负数
var distributeCoinsEx = function (root, moveCount, needcoins) {
  if (!root) {
    return [moveCount, needcoins];
  }
  let [lmoveCount, lneedcoins] = distributeCoinsEx(root.left, moveCount, needcoins);
  let [rmoveCount, rneedcoins] = distributeCoinsEx(root.right, moveCount, needcoins);
  needcoins = (1 - root.val) + lneedcoins + rneedcoins;
  moveCount = Math.abs(needcoins) + lmoveCount + rmoveCount;
  return [moveCount, needcoins];
}

const treeNode = require('./TreeNode');
const root = treeNode.createTreeNode([0,3,0]);
r = distributeCoins(root);
console.warn(r);