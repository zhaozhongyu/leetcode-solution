/**
 * @param {string} s
 * @param {string[]} wordDict
 * @return {string[]}
 */
var wordBreak = function (s, wordDict) {
  const set = new Set();
  for (let word of wordDict) {
    set.add(word);
  }
  let n = s.length;
  const ret = [], tmp = [];
  const dfs = (i) => {
    if (i >= n) {
      ret.push(tmp.join(' '));
      return;
    }
    for (let j = i; j < n + 1; ++j) {
      const sub = s.slice(i, j);
      if (set.has(sub)) {
        tmp.push(sub);
        dfs(j);
        tmp.pop();
      }
    }
  }
  dfs(0);
  return ret;
};

//console.warn(wordBreak("catsanddog", ["cat", "cats", "and", "sand", "dog"]))
console.warn(wordBreak("pineapplepenapple", ["apple", "pen", "applepen", "pine", "pineapple"]))