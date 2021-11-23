/**
 * @param {string} s
 * @param {string} goal
 * @return {boolean}
 */
var buddyStrings = function(s, goal) {
  if (s === goal) {
    return new Set(s).size !== s.length;
  }
  if (s.length !== goal.length || s.length < 2) {
    return false;
  }
  let i = -1, j = -1;
  for (let k = 0; k < s.length; k++) {
    if (s[k] !== goal[k]) {
      if (i !== -1 && j !== -1) {
        return false;
      } else if (i === -1) {
        i = k;
      } else {
        j = k;
      }
    }
  }
  if (s[i] === goal[j] && s[j] === goal[i]) {
    return true;
  }
  return false;
};

buddyStrings('aaaaaaabc', 'aaaaaaacb');