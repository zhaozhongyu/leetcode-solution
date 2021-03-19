/**
 * @param {string[]} words
 * @return {string[]}
 */
var findWords = function(words) {
    var one = "qwertyuiopQWERTYUIOP";
    var two = "asdfghjklASDFGHJKL";
    var three = "zxcvbnmZXCVBNM";
    var pattern;
    var result = [];
    while(words.length !== 0){
        var word = words.shift();
        if(one.indexOf(word[0]) != -1){
            pattern = one;
        } else if (two.indexOf(word[0]) != -1) {
            pattern = two;
        } else {
            pattern = three;
        }
        for(var i = 0; i < word.length; i++){
            if(pattern.indexOf(word[i]) == -1){
                break;
            }
            if(i === word.length-1){
                result.push(word);
            }
        }
    }
    return result;
};
