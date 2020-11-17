/**
 * @param {number} n
 * @return {string[]}
 */
var fizzBuzz = function(n) {
    var f = [];
    for(var i = 1; i <= n; i++){
        if (i % 3 === 0 && i % 5 !== 0){
            f.push("Fizz");
        }
        else if (i % 3 !== 0 && i % 5 ===0){
            f.push("Buzz");
        }
        else if(i % 3 ===0 && i % 5 ===0 && i > 1){
            f.push("FizzBuzz");
        }
        else {
            f.push(i+"");
        }
    }
    return f;
};
