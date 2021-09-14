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
 */
var CBTInserter = function(root) {
  this.root = root;
  this.count = 1;
  const l = [ this.root ]
  while (l.length > 0) {
    const treenode = l.pop();
    if (treenode.left) {
      l.push(treenode.left);
      this.count++;
      if (treenode.right) {
        l.push(treenode.right);
        this.count++;
      }
    }
  }
};

/** 
 * @param {number} val
 * @return {number}
 */
CBTInserter.prototype.insert = function(val) {
  // i 第几层, count 第几位
  let i = 0, count = this.count;
  this.count++;
  while (true) {
    const num = Math.pow(2, i);
    if (count >= num) {
      count -= num;
      i++;
    } else {
      break;
    }
  }
  const l = []
  while (--i) {
    count = Math.floor(count / 2);
    l.push(count % 2);
  }
  let node = this.root;
  while (l.length > 0) {
    const n = l.pop();
    node = n === 0 ? node.left : node.right;
  }
  if (node.left) {
    node.right = { val, left: null, right: null }
  } else {
    node.left = { val, left: null, right: null }
  }
  return node.val;
};

/**
 * @return {TreeNode}
 */
CBTInserter.prototype.get_root = function() {
  return this.root;
};

/**
 * Your CBTInserter object will be instantiated and called as such:
 * var obj = new CBTInserter(root)
 * var param_1 = obj.insert(val)
 * var param_2 = obj.get_root()
 */
var obj = new CBTInserter({ val: 1 })
for (let i = 2; i < 9; i++) {
  obj.insert(i);
}
console.log(obj.get_root());