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
var levelOrder = function(root) {
    const res = [];
    if (!root) return res;
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
        res.push(vals);
        if (!levels.length) break;
    }
    return res;
};