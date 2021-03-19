/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */
var maxDepth = function(root) {
    var node;
    var left ;
    var right ;
    var num = 0;
    var list = [];
    if(root !== null){
        root.val = 1;
        list.push(root);
    }
    
    while(list.length !== 0){
        node = list.pop();
        if(node.left !== null){
            node.left.val = node.val + 1
            list.push(node.left)
        }
        if(node.right !== null) {
            node.right.val = node.val + 1
            list.push(node.right)
        }
        if(node.left === null && node.right === null && node.val > num) {
            num = node.val;
        }
    }
    return num;
};
