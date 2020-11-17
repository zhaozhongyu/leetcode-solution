/**
 * @param {number} x
 * @param {number} y
 * @return {number}
 */
var hammingDistance = function(x, y) {
    var str = "00000000000000000000000000000000"
    x = str+x.toString(2);
    y = str+y.toString(2);
    var num = 0;
    x = x.substring(x.length-32);
    y = y.substring(y.length-32);
    for(var i = 0;i < 32;i++) {
        if(x[i] != y[i] ){
            num++;
        }
    }
    return num;
};
