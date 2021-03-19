/**
 * @param {number[]} nums
 * @return {number}
 */
var singleNumber = function(nums) {
    nums.sort()
    for(var i = 0; i < nums.length;){
        if(nums[i] === nums[i+1]){
            i += 2;
        } else {
            return nums[i]
        }
    }
};
