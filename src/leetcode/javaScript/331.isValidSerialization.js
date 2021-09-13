/**
 * @param {string} preorder
 * @return {boolean}
 */
var isValidSerialization = function(preorder) {
  const preorderlist = preorder.split(',');
  if (preorderlist.length % 2 === 0) {
    return false;
  }
  // 未验证节点的节点index
  const list = [];
  let index = 0;
  const addLeft = function () {
    while (preorderlist.length > index) {
      if (preorderlist[index] === '#') {
        index++;
        break;
      }
      list.push(preorderlist[index++]);
    }
  }
  addLeft();
  while (list.length !== 0 && preorderlist.length > index) {
    list.pop()
    if (preorderlist[index] === '#') {
      index++;
    } else {
      addLeft();
    }
  }
  return index === preorderlist.length && list.length === 0;

};

isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#");