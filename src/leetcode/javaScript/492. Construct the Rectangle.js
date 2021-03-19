/**
 * @param {number} area
 * @return {number[]}
 */
var constructRectangle = function(area) {
    var nums = [];
    var sqrt = Math.sqrt(area);
    if(parseInt(sqrt) === sqrt) {
        nums.push(sqrt, sqrt);
        return nums;
    }
    for(var i = parseInt(sqrt) + 1; i <= area; i++){
        var n = area / i;
        if (parseInt(n) === n){
            nums.push(i, n);
            return nums;
        }
    }
    return nums;
};
