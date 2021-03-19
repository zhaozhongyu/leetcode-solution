/**
 * @param {number} num
 * @return {number}
 */
var addDigits = function(num) {
    var a,b;
    while(num > 9){
        a = parseInt(num /10);
        b = num % 10;
        num = a + b;
    }
    return num;
};
