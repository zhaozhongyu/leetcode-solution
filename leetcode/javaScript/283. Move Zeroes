/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var moveZeroes = function(nums) {
    var n = 0;
    if(nums === null || nums.length === 0){
        return ;
    }
    for(var i = 0;i < nums.length; i++){
        if(nums[i] === 0){
            nums.splice(i, 1);
            i--;
            n++;
        }
    }
    for(var i = 0; i < n; i++){
        nums.push(0);
    }
};
