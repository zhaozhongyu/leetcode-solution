/**
     sum + m * (n - 1) = x * n
     x = min + m                    -->sum - min * n = m

*/

/**
 * @param {number[]} nums
 * @return {number}
 */
var minMoves = function(nums) {
        nums.sort(function(a,b){return a-b})
    var min = nums[0];
    var sum = 0;
    for(var i = 0;i < nums.length; i++){
        sum += nums[i];
    }
    
    return sum - min * nums.length;
};
