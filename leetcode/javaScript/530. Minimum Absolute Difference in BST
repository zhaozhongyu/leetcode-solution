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
var getMinimumDifference = function(root) {
    var list = [];
    var nums = [];
    var result;
    var node;
    if(root !== null){
        list.push(root);
    }
    while(list.length != 0){
        node = list.pop();
        nums.push(node.val);
        if(node.left != null){
            list.push(node.left);
        }
        if(node.right != null){
            list.push(node.right);
        }
    }
    nums.sort(function (a,b) {return a-b;});
    result = nums[1] - nums[0];
    for(var i = 0; i < nums.length-1; i++){
        result = result<nums[i+1]-nums[i]?result:nums[i+1]-nums[i];
    }
    return result;
};
