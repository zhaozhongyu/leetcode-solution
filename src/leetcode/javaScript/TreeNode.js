class TreeNode {
  constructor(val, left, right) {
    this.val = (val===undefined ? 0 : val)
    this.left = (left===undefined ? null : left)
    this.right = (right===undefined ? null : right)
  }
}

function createTreeNode(nums) {
  let root = new TreeNode(nums[0]);
  let list = [];
  list.push(root);
  for (let i = 1; i < nums.length; i+=2) {
    let node = list.shift();
    if (nums[i] != null) {
      node.left = new TreeNode(nums[i]);
      list.push(node.left);
    }
    if (i+1 < nums.length && nums[i+1] != null) {
        node.right = new TreeNode(nums[i+1]);
        list.push(node.right);
    }
  }
  return root;
}

function printTreeNode(root) {
  let vals = [];
  let list = [root];
  while (list.length) {
    let node = list.shift();
    vals.push(node && node.val || 'null');
    if (node) {
      list.push(node.left);
      list.push(node.right);
    }
  }
  for (let i = vals.length - 1; i >= 0; i--) {
    if (vals[i] !== 'null') {
      vals = vals.slice(0, i + 1);
      break;
    }
  }
  console.log('[' + vals.join(',') + ']');
}

module.exports.createTreeNode = createTreeNode
module.exports.TreeNode = TreeNode
module.exports.printTreeNode = printTreeNode;
