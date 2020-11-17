/**
 * @param {number[]} nums
 * @return {number}
 */
var findMaxConsecutiveOnes = function(nums) {
    var result = 0;
    var num = 0;
    for(var i = 0; i < nums.length; i++){
        if(nums[i] === 1 ){
            num++;
        } else {
            result = result > num?result:num;
            num = 0;
        }
    }
    result = result > num?result:num;
    return result;
};
