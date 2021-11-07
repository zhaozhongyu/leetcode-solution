/**
 * @param {number} m
 * @param {number} n
 * @param {number[][]} ops
 * @return {number}
 */
var maxCount = function(m, n, ops) {
  let column = m, row = n;
  for (let i = 0; i < ops.length; i++) {
    column = Math.min(column, ops[i][0]);
    row = Math.min(row, ops[i][1]);
  }
  return column * row;
};