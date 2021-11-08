/**
 * @param {string} secret
 * @param {string} guess
 * @return {string}
 */
var getHint = function(secret, guess) {
  let map = {};
  let bulls = 0, cows = 0;
  for (let i = 0; i < secret.length; i++) {
    const c = secret[i];
    if (c === guess[i]) {
      bulls++;
    } else if (map[c]) {
      map[c].push(i);
    } else {
      map[c] = [i];
    }
  }
  
  for (let i = 0; i < guess.length; i++) {
    let c = guess[i];
    if (secret[i] !== c && map[c] && map[c].length) {
      cows++;
      map[c].shift();
    }
  }
  return `${bulls}A${cows}B`;
};