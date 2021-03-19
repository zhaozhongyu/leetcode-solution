/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number[]}
 */
var intersection = function(nums1, nums2) {
    var result = []
    for(var i of nums2){
        if(nums1.includes(i) && ! result.includes(i)){
            result.push(i)
        }
    }
    return result;
};
