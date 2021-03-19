/**
 * @param {string} s
 * @return {string}
 */
var reverseWords = function(s) {
    var list = s.split("\ ");
    var l;
    for (var i = 0; i < list.length; i++){
        l = list[i].split("");
        l.reverse()
        list[i] = l.join("");
    }
    return list.join(" ")
};
