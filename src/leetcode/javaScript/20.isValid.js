/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
 * @param {string} s
 * @return {boolean}
 */
var isValid = function(s) {
  const list = ['(', '[', '{'];
  const map = { ')': '(', ']': '[', '}': '{' };
  const stack = [];
  for (let c of s) {
    if (list.includes(c)) {
      stack.push(c);
    } else {
      const c1 = map[c];
      if (c1 !== stack.pop()) {
        return false;
      }
    }
  }
  if (stack.length) {
    return false;
  }
  return true;
};