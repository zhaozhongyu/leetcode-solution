/**
 * @param {number[]} nums
 * @return {number}
 */
var missingNumber = function(nums) {
  let res = 0;
  for (let i = 0; i < nums.length; i++) {
    res -= nums[i];
    res += i + 1;
  }
  return res;
};