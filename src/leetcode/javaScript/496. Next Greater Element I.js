/**
 * @param {number[]} findNums
 * @param {number[]} nums
 * @return {number[]}
 */
var nextGreaterElement = function(findNums, nums) {
    var result = [];
    for (var i = 0; i < findNums.length; i++){
        for(var j = nums.indexOf(findNums[i]); j < nums.length; j++){
            if(nums[j] > findNums[i]){
                result[i] = nums[j];
                break;
            }
        }
        if (result[i] == null){
            result[i] = -1;
        }
    }
    return result;
};
