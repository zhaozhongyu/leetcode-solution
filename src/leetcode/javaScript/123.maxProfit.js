
/**
 * @param {number[]} prices
 * @return {number}
 * 官方答案
 * 未进行过任何操作；

只进行过一次买操作；

进行了一次买操作和一次卖操作，即完成了一笔交易；

在完成了一笔交易的前提下，进行了第二次买操作；

完成了全部两笔交易。

 */
var maxProfit = function(prices) {
  const n = prices.length;
  let buy1 = -prices[0], buy2 = -prices[0];
  let sell1 = 0, sell2 = 0;
  for (let i = 1; i < n; i++) {
      buy1 = Math.max(buy1, -prices[i]);
      sell1 = Math.max(sell1, buy1 + prices[i]);
      buy2 = Math.max(buy2, sell1 - prices[i]);
      sell2 = Math.max(sell2, buy2 + prices[i]);
  }
  return sell2;
};
