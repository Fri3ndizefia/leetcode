package com.Solutions;

/**
 * DP篇
 * 股票交易系列
 * 冷冻期的加入
 */
public class solution309 {
    public int maxProfit(int[] prices) {
        /**
         * 状态：
         * 买了一次，存着股票 对应收益 f[i][0]
         * 卖掉一次，没有股票，冷冻期进入 f[i][1]
         * 没有股票，没有冷冻期 f[i][2]
         *
         * 状态转移：
         * f[i][0] = max( f[i-1][0], f[i-1][2] - prices[i])
         * 要么留着之前买的股票，要么在非冷冻期进行购买
         *
         * f[i][1] = f[i-1][0] + prices[i]
         * 持有股票才能卖股票赚钱
         *
         * f[i][2] = max(f[i-1][1], f[i-1][2]);
         * 要么是刚卖掉，存在冷冻期
         * 要么是就已经在冷冻期，没有股票
         *
         * 如果在最后一天， n-1天还拥有股票是无意义的操作
         * max(f[n-1][1], f[n-1][2])
         */
        int len = prices.length;
        if(len < 2) return 0;
        int[][] dp = new int[len][3];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;
        for (int i = 1; i < len; ++i) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            dp[i][1] = dp[i - 1][0] + prices[i];
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1]);
        }
        return Math.max(dp[len - 1][1], dp[len - 1][2]);
    }


    /**
     * 优化空间方案
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int len = prices.length;
        if(len < 2) return 0;
        int dp0 = -prices[0];
        int dp1 = 0;
        int dp2 = 0;
        for(int i = 1; i< len; ++i){
            int new0 = Math.max(dp0, dp2 - prices[i]);
            int new1 = dp0 + prices[i];
            int new2 = Math.max(dp1,dp2);
            dp0 = new0;
            dp1 = new1;
            dp2 = new2;
        }
        return Math.max(dp1,dp2);
    }
}
