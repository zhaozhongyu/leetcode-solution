/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * 102.%20二叉树的层序遍历.js的简单变种
 * @param {TreeNode} root
 * @return {number[][]}
 */
var levelOrderBottom = function(root) {
    const res = [];
    if (!root) return res;
    // 不可能通过简单的先序/后序遍历的方式完成层级遍历, 需要其他的方式
    let levels = [root];
    while (true) {
        let next = [];
        const vals = [];
        while(levels.length) {
            const node = levels.shift();
            vals.push(node.val);
            if (node.left) next.push(node.left);
            if (node.right) next.push(node.right);
        }
        levels = next;
        res.unshift(vals);
        if (!levels.length) break;
    }
    return res;
};