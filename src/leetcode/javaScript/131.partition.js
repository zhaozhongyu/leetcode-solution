/**
 * @param {string} s
 * @return {string[][]}
 */
var partition = function (s) {
  const len = s.length;
  const dp = new Array(len + 1).fill(0).map(() => new Array(len + 1).fill(true));
  // 显然, 当i>j时, i=j时, 空串/1个字符为回文串
  for (let i = len - 1; i >= 0; --i) {
    for (let j = i + 1; j < len; ++j) {
      dp[i][j] = s[i] === s[j] && dp[i + 1][j - 1];
    }
  }

  const ret = [], tmp = [];
  // 全递归
  const dfs = (i) => {
    if (i === len) {
      ret.push(tmp.slice());
      return;
    }
    for (let j = i; j < len; ++j) {
      if (dp[i][j]) {
        tmp.push(s.slice(i, j + 1));
        dfs(j + 1);
        tmp.pop();
      }
    }
  };
  dfs(0);
  return ret;
};