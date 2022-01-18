// public boolean wordBreak(String s, List<String> wordDict) {
//   // 可以类比于背包问题
//   int n = s.length();
//   // memo[i] 表示 s 中以 i - 1 结尾的字符串是否可被 wordDict 拆分
//   boolean[] memo = new boolean[n + 1];
//   memo[0] = true;
//   for (int i = 1; i <= n; i++) {
//       for (int j = 0; j < i; j++) {
//           if (memo[j] && wordDict.contains(s.substring(j, i))) {
//               memo[i] = true;
//               break;
//           }
//       }
//   }
//   return memo[n];
// }
/**
 * @param {string} s
 * @param {string[]} wordDict
 * @return {boolean}
 */
var wordBreak = function(s, wordDict) {
  const n = s.length;
  let ret = new Array(n + 1).fill(false);
  ret[0] = true;
  for (let i = 1; i <= n; ++i) {
    for (let j = 0; j < i; ++j) {
      if (ret[j] && wordDict.includes(s.slice(j, i))) {
        ret[i] = true;
        break;
      }
    }
  }
  return ret[n];
};