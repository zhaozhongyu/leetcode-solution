/**
 * @param {number[]} nums
 * @return {string[]}
 */
var findRelativeRanks = function(nums) {
    var strings = nums.slice(0);
    strings.sort(function(a,b){return b-a});
    var num;
    for(var i = 0; i < nums.length; i++){
        num = nums.indexOf(strings[i]);
        if(i === 0){
            nums.splice(num, 1, "Gold Medal")
        } else if(i === 1){
            nums.splice(num, 1, "Silver Medal")
        } else if(i === 2){
            nums.splice(num, 1, "Bronze Medal")
        } else {
            nums.splice(nums.indexOf(strings[i]), 1, i+1+"")
        }
    }
    return nums;
};
