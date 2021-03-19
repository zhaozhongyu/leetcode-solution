/**
 * @param {number[]} nums
 * @return {number}
 */
var minMoves2 = function(nums) {
    var sum = 0;
    nums.sort(function (a,b) {return a-b})
    var i = 0, j = nums.length - 1;
    while(i < j){
        sum += nums[j--]-nums[i++];
    }
    
    return sum;
};
