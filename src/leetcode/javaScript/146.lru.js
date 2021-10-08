/**
 * @param {number} capacity
 */
var LRUCache = function(capacity) {
  this.capacity = capacity;
  this.cache = {};
  this.firstNode = {};
  this.lastNode = { pre: this.firstNode };
  this.firstNode.next = this.lastNode;
  this.num = 0;
};

var deleteNode = function (node) {
  let preNode = node.pre;
  let nextNode = node.next;
  node.pre = node.next = null;
  preNode.next = nextNode;
  nextNode.pre = preNode;
}

var insertNode = function (preNode, node) {
  let nextNode = preNode.next;
  nextNode.pre = node;
  node.next = nextNode;
  preNode.next = node;
  node.pre = preNode;
}

/** 
 * @param {number} key
 * @return {number}
 */
LRUCache.prototype.get = function(key) {
  let node = this.cache[key];
  if (node !== undefined) {
    deleteNode(node);
    insertNode(this.firstNode, node);
  }
  if (node !== undefined) {
    return node.val;
  }
  return -1;
};

/** 
 * @param {number} key 
 * @param {number} value
 * @return {void}
 */
LRUCache.prototype.put = function (key, val) {
  let node 
  if (this.cache[key] !== undefined) {
    node = this.cache[key];
  } else if (this.num === this.capacity){
    node = this.lastNode.pre;
  } else {
    this.num++;
  }
  if (node) {
    delete this.cache[node.key];
    deleteNode(node);
  }
  let temp = { key, val };
  insertNode(this.firstNode, temp);
  this.cache[key] = temp;
};

/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = new LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */
 let lRUCache = new LRUCache(2);
 lRUCache.put(1, 0); // 缓存是 {1=1}
 lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
 lRUCache.get(1);    // 返回 1
 lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
 lRUCache.get(2);    // 返回 -1 (未找到)
 lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
 lRUCache.get(1);    // 返回 -1 (未找到)
 lRUCache.get(3);    // 返回 3
 lRUCache.get(4);    // 返回 4
