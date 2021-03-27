package com.Solutions;

/**
 * DP篇
 * 股票交易系列
 * 股票交易手续费
 */
public class solution714 {
    public int maxProfit(int[] prices, int fee) {

        /**
         *
         * 状态：
         * 买股票，持股 f[i][1] = f[i-1][0] - prices[i], f[i-1][1]
         * 卖股票了，无股 f[i][0] = f[i-1][1] + prices[i] - fee, f[i-1][0]
         */
        int len = prices.length;
        if(len < 2) return 0;

        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; ++i) {
            dp[i][0] = Math.max(dp[i - 1][1] + prices[i] - fee, dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
        }
        return dp[len-1][0];
    }


}
