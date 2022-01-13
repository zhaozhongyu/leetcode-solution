/**
 * @param {string} s1
 * @param {string} s2
 * @param {string} s3
 * @return {boolean}
 */

/**
 * f(i, j) = {
 *  f(i-1, j), if s1[i] == s3[i+j]
 *  f(i, j -1), if s2[j] == s3[i + j]
 *  f(i-i, j) || f(i, j -1), if s1[i] == s3[i+j] && s2[j] == s3[i+j]
 * }
 */
var isInterleave = function(s1, s2, s3) {
  if (s1.length + s2.length !== s3.length) {
    return false;
  }

  let f = [[]];
  f[0][0] = true;
  for (let i = 0; i <= s1.length; i++) {
    if (!f[i]) {
      f[i] = [];
    }
    for (let j = 0; j <= s2.length; j++) {
      let p = i + j - 1;
      if (i > 0) {
        f[i][j] = f[i][j] || (f[i - 1][j] && s1.charAt(i - 1) === s3.charAt(p));
      }
      if (j > 0) {
        f[i][j] = f[i][j] || (f[i][j - 1] && s2.charAt(j - 1) === s3.charAt(p));
      }
    }
  }
  return f[s1.length][s2.length];
};

console.log(isInterleave("aabcc",
  "dbbca",
  "aadbbbaccc"));



// 超时
var isInterleave1 = function(s1, s2, s3) {
  if (s1.length + s2.length !== s3.length) {
    return false;
  }
  if (s3 === '') {
    return true;
  }
  if (s1[0] !== s3[0] && s2[0] !== s3[0]) {
    return false;
  }
  let p = 0;
  for (let i = 1; i <= s1.length; i++) {
    if (s1.slice(0, i) === s3.slice(0, i)) {
      if (isInterleave(s1.slice(i), s2, s3.slice(i))) {
        return true;
      }
    } else {
      break;
    }
  }
  for (let i = 1; i <= s2.length; i++) {
    if (s2.slice(0, i) === s3.slice(0, i)) {
      if (isInterleave(s1, s2.slice(i), s3.slice(i))) {
        return true;
      }
    } else {
      break;
    }
  }
  return false;
};