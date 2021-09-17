/**
 * @param {number[]} preorder
 * @return {TreeNode}
 */
var bstFromPreorder = function(preorder) {
  if (preorder.length === 0) {
    return null;
  }
  let root = { val: preorder[0], left: null, right: null };
  let index = preorder.findIndex((val) => val > preorder[0]);
  if (index !== -1) {
    root.left = bstFromPreorder(preorder.slice(1, index));
    root.right = bstFromPreorder(preorder.slice(index));
  } else {
    root.left = bstFromPreorder(preorder.slice(1));
  }
  return root;
};
