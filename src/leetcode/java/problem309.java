package leetcode.java;

public class problem309 {

    /**
     * 买入的条件: prices[i] < prices[i+1] && i < prices.length - 1
     * 卖出的条件: prices[i] > prices[i + 2] && i + 2 < prices.length - 1, 必要条件1
     *           prices[i+1] - prices[i+3] < prices[i] - prices[i + 2]
     * 倒数3天的计算直接取最大最小值
     */
    // 这道题告诉我一件事: dp就好好用dp的方法解, 不要总想着找多项式.
    // dp不排斥多使用空间, 以及, 似乎我现在只熟悉递归形式写法的dp
    public int maxProfit(int[] prices) {
        // 卖出的理由
        if (prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        // f[i][0]: 手上持有股票的最大收益
        // f[i][1]: 手上不持有股票，并且处于冷冻期中的累计最大收益
        // f[i][2]: 手上不持有股票，并且不在冷冻期中的累计最大收益
        int[][] f = new int[n][3];
        f[0][0] = -prices[0];
        for (int i = 1; i < n; ++i) {
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][2] - prices[i]);
            f[i][1] = f[i - 1][0] + prices[i];
            f[i][2] = Math.max(f[i - 1][1], f[i - 1][2]);
        }
        return Math.max(f[n - 1][1], f[n - 1][2]);
    }
}
