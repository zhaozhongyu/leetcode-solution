/**
 * @param {string} s
 * @param {string} t
 * @return {character}
 */
var findTheDifference = function(s, t) {
    var len = t.length;
    var ms = new Map();
    var num ;
    for(var i = 0; i < len - 1; i++) {
        num = ms.get(s[i]);
        if (num === undefined) {
            ms.set(s[i], 1);
        } else {
            ms.set(s[i], num + 1);
        }
    }
    for(i = 0; i < len; i++) {
        num = ms.get(t[i]);
        if(num === undefined) {
            ms.set(t[i], -1);
        } else {
            ms.set(t[i], num - 1);
        }
    }
    for (var key of ms.keys()){
        
        if (ms.get(key) == -1){
            return key;
        }
    }
};
