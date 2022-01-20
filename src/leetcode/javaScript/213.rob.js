/**
 * @param {number[]} nums
 * @return {number}
 * 设dp[i]表示打劫第i座房屋时可以获取到的最大值
 * dp[i] = max(dp[i - 2] + nums[i], dp[i - 1])
 */
var rob = function (nums) {
  const n = nums.length;
  if (n <= 3) {
    return Math.max(...nums);
  }
  const dp = new Array(n).fill(0);
  const dp1 = new Array(n).fill(0);
  dp[0] = nums[0]; dp[1] = Math.max(nums[0], nums[1]);
  dp1[1] = nums[1];
  // 因为首尾相连, 所以分两次计算, 分别计算含第一个和含最后一个的情况
  for (let i = 2; i < n - 1; i++) {
    dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
    dp1[i] = Math.max(dp1[i - 2] + nums[i], dp1[i - 1]);
  }
  dp1[n - 1] = Math.max(dp1[n - 3] + nums[n - 1], dp1[n - 2]);
  return Math.max(dp1[n - 1], dp[n - 2]);
};

console.warn(rob([4,1,2,7,5,3,1]))