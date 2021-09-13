/**
 * 最小堆问题
 * @param {number} k
 * @param {number[]} nums
 */
var KthLargest = function (k, nums) {
  this.heaplen = k;
  this.heap = [];
  for (let num of nums) {
    this.add(num);
  }
};

/**
 * 插入时, 先判断长度是否已满, 如果未满则直接插入, 如果已满则判断顶部元素
 * @param {number} val
 * @return {number}
 */
KthLargest.prototype.add = function(val) {
  if (this.heap.length < this.heaplen) {
    this.heap.splice(0, 0, val);
    this.min_heapify(0);
  } else if (val > this.heap[0]) {
    this.heap[0] = val;
    this.min_heapify(0);
  }
  return this.heap[0];
};
KthLargest.prototype.leftChild = function (cur) {
  return (cur + 1) << 1 - 1;
};
KthLargest.prototype.rightChild = function (cur) {
  return (cur + 1) << 1;
};
KthLargest.prototype.min_heapify = function (index) {
  const lchild = this.leftChild(index);
  let min = index;
  if (lchild < this.heap.length && this.heap[lchild] < this.heap[index]) {
    min = lchild
  } else {
    const rchild = this.rightChild(index);
    if (rchild < this.heap.length && this.heap[rchild] < this.heap[index]) {
      min = rchild;
    }
  }
  if (min !== index) {
    let tmp = this.heap[index];
    this.heap[index] = this.heap[min];
    this.heap[min] = tmp;
    this.min_heapify(min);
  }
}

var obj = new KthLargest(3, [4, 5, 8, 2])
console.warn(obj.add(3))
console.warn(obj.add(5))
console.warn(obj.add(10))
console.warn(obj.add(9))
/**
 * Your KthLargest object will be instantiated and called as such:
 * var obj = new KthLargest(k, nums)
 * var param_1 = obj.add(val)
 */