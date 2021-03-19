/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {TreeNode}
 */
var invertTree = function(root) {
    var temp, node, list = [];
    if(root !== null){
        list.push(root);
    }
    while(list.length !== 0){
        node = list.pop();
        temp = node.left;
        node.left = node.right;
        node.right = temp;
        if(node.left !== null){
            list.push(node.left);
        }
        if(node.right !== null){
            list.push(node.right);
        }
    }
    return root;
};
