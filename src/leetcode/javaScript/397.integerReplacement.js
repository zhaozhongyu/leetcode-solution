/**
 * @param {number} n
 * @return {number}
 */
const map = {};
var integerReplacement = function(n) {
    if (n === 1) {
        return 0;
    }
    if (map[n]) {
        return map[n];
    }
    if (n % 2 === 0) {
        return map[n] = integerReplacement(n / 2) + 1;
    } else {
        return map[n] = Math.min(integerReplacement(n + 1), integerReplacement(n - 1)) + 1;
    }
};