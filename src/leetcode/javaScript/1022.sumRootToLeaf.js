var sumRootToLeaf = function(root) {
  let sum = 0;
  let ret = leafsToRoot(root);
  ret.forEach(val => sum += parseInt(val, 2));
  return sum;
};

var leafsToRoot = function (root) {
  if (!root) {
    return [];
  }
  let ret = [];
  if (!root.left && !root.right) {
    return [root.val];
  }
  if (root.left) {
    let left = leafsToRoot(root.left);
    left.forEach(val => ret.push(`${root.val}${val}`));
  }
  if (root.right) {
    let right = leafsToRoot(root.right);
    right.forEach(val => ret.push(`${root.val}${val}`));
  }
  return ret;
}