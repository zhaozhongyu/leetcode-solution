/**
 * @description 全排列问题2, 带重复的全排列
 * @param {number[]} nums
 * @return {number[][]}
 */

var subsetsWithDup = function(nums) {
  nums.sort((a, b) => a - b);
  let t = [], ans = [];
  const dfs = (choosePre, cur, nums) => {
      if (cur === nums.length) {
          ans.push(t.slice());
          return;
      }
      dfs(false, cur + 1, nums);
      if (!choosePre && cur > 0 && nums[cur - 1] === nums[cur]) {
          return;
      }
      t.push(nums[cur]);
      dfs(true, cur + 1, nums);
      t = t.slice(0, t.length - 1);
  }
  dfs(false, 0, nums);
  return ans;
};


console.warn(subsetsWithDup([1,2,2]))