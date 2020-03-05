/**
 * @param {string} ransomNote
 * @param {string} magazine
 * @return {boolean}
 */
var canConstruct = function(ransomNote, magazine) {
    var words = new Int32Array(27) ;
    for(var i = 0; i < magazine.length;i++){
        words[magazine.charCodeAt(i) - 97]++;
    }
    for(i = 0; i < ransomNote.length;i++) {
        if(--words[ransomNote.charCodeAt(i) - 97] < 0){
            return false;
        }
    }

    return true;
};
