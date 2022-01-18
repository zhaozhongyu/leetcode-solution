/**
 * @param {string} s
 * @return {number}
 * f(i, j) = {
 *  f(i, j+1), if s[i][j]不是回文串
 *  min(f(i, j+1), f(i+1, j+1) + 1), if s[i][j]是回文串
 * }
 */
var minCut = function(s) {
  const len = s.length;
  const dp = new Array(len).fill(0).map(() => new Array(len).fill(true));
  // 显然, 当i>j时, i=j时, 空串/1个字符为回文串
  for (let i = len - 1; i >= 0; --i) {
    for (let j = i + 1; j < len; ++j) {
      dp[i][j] = s[i] === s[j] && dp[i + 1][j - 1];
    }
  }
  const ret = new Array(len).fill(Number.MAX_SAFE_INTEGER);
  for (let i = 0; i < len; ++i) {
    if (dp[0][i]) {
      ret[i] = 0;
    } else {
      for (let j = 0; j < i; ++j) {
        if (dp[j + 1][i]) {
          ret[i] = Math.min(ret[i], ret[j] + 1);
        }
      }
    }
  }
  return ret[len - 1];
};



console.warn(minCut("aab"))