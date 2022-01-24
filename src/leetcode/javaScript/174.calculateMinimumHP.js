/**
 * @param {number[][]} dungeon
 * @return {number}
 * // 从右下到左上遍历
 */
var calculateMinimumHP = function(dungeon) {
  const dp = new Array(dungeon.length + 1).fill(0).map((val) => new Array(dungeon[0].length + 1).fill(Number.MAX_SAFE_INTEGER));
  let n = dungeon.length;
  let m = dungeon[0].length;
  dp[n][m - 1] = dp[n - 1][m] = 1;
  // 
  for (let i = n - 1; i >= 0; --i) {
    for (let j = m - 1; j >= 0; --j) {
      dp[i][j] = Math.max(Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j], 1);
    }
  }

  return dp[0][0];
};

console.warn(calculateMinimumHP([[-2,-3,3],[-5,-10,1],[10,30,-5]]))