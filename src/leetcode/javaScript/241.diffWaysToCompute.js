/**
 * @param {string} expression
 * @return {number[]}
 */
const cache = {};
var diffWaysToCompute = function(expression) {
  if (!isNaN(expression)) {
    return [Number(expression)];
  }
  const result = [];
  for (let i = 1; i < expression.length - 1; i++) {
    const c = expression[i];
    if (['+', '-', '*'].includes(c)) {
      const left = diffWaysToCompute(expression.slice(0, i));
      const right = diffWaysToCompute(expression.slice(i + 1));
      if (c === '+') {
        for (let l of left) {
          for (let r of right) {
            result.push(l+r);
          }
        }
      } else if (c === '-') {
        for (let l of left) {
          for (let r of right) {
            result.push(l-r);
          }
        }
      } else {
        for (let l of left) {
          for (let r of right) {
            result.push(l*r);
          }
        }
      }
    }
  }
  return cache[expression] = Array.from(result);
};

console.log(diffWaysToCompute('2*3-4*5'));