/**
 * @param {string} word
 * @return {boolean}
 */
var detectCapitalUse = function(word) {
    if (word === word.toUpperCase()){
        return true;
    }
    if(word === word.toLowerCase()) {
        return true;
    }
    var w = word[0].toUpperCase();
    if(word === (w + word.slice(1).toLowerCase())){
        return true;
    }
    return false;
};
