/**
 * @param {number[]} nums
 * @return {number[]}
 */
var findDisappearedNumbers = function(nums) {
    var ret = [];
    for(var i = 0; i < nums.length; i++){
        var val = Math.abs(nums[i]) -1;
        if(nums[val] > 0){
            nums[val] = - nums[val]
        }
    }
    for( i = 0; i < nums.length;i++){
        if(nums[i] > 0){
            ret.push(i+1);
        }
    }
    return ret;
};
