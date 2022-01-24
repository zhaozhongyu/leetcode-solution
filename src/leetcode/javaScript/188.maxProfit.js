/**
 * @param {number} k
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(k, prices) {
  const n = prices.length;
  let buys = new Array(k + 1).fill(-prices[0]);
  let sells = new Array(k + 1).fill(0);
  for (let i = 1; i < n; i++) {
    for (let j = 1; j <= k; j++) {
      buys[j] = Math.max(buys[j], sells[j - 1] - prices[i]);
      sells[j] = Math.max(sells[j], buys[j] + prices[i]);
    }
  }
  return sells[k];
};