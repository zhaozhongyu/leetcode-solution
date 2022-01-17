/**
 * @param {string} s
 * @param {string} t
 * @return {number}
 * dp[i][j] = {
 *  dp[i + 1][j] + dp[i+1][j+1], if s[i] === t[j]: 相等时, 有选与不选的区别
 *  dp[i+1][j], if s[i] !== t[j]
 * } 
 */
var numDistinct = function(s, t) {
  const sl = s.length, tl = t.length;
  if (sl < tl) {
    return 0;
  }
  const dp = new Array(sl + 1).fill(0).map(() => new Array(tl + 1).fill(0));
  for (let i = 0; i <= sl; i++) {
    dp[i][tl] = 1;
  }
  for (let i = sl - 1; i>=0; i--) {
    for (let j = tl - 1; j >= 0; j--) {
      if (s[i] === t[j]) {
        dp[i][j] = dp[i+1][j] + dp[i+1][j+1];
      } else {
        dp[i][j] = dp[i+1][j];
      }
    }
  }
  return dp[0][0];
};

// 当选用了s[i]之后, 问题就简化成s.slice(i+1), t.slice(1)
var numDistinct1 = function (s, t) {
  if (t.length === 0) {
    return 1;
  }
  if (t === s) {
    return 1;
  }
  if (t.length >= s.length) {
    return 0;
  }
  
  let count = 0;
  let c = t[0];
  for (let i = 0; i < s.length; i++) {
    if (s[i] === c) {
      count += numDistinct1(s.slice(i + 1), t.slice(1));
    }
  }
  return count;
  
};

console.warn(numDistinct("rabbbit", "rabbit"));