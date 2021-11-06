/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function(nums, target) {
  return binSearch(nums, target, 0, nums.length - 1);
};

function binSearch (nums, target, left, right) {
  if (left > right) {
    return -1;
  }
  const mid = Math.floor((left + right + 1) / 2);
  if (nums[mid] === target) {
    return mid;
  }
  if (target < nums[mid]) {
    return binSearch(nums, target, left, mid - 1);
  } else {
    return binSearch(nums, target, mid + 1, right);
  }
}

console.log(search([5], 5));