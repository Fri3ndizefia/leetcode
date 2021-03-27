package com.Solutions;

/**
 * DP篇
 * 股票系列
 * 多次交易
 */
public class solution122 {

    /**
     * 贪心算法
     */
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len < 2 ) return 0;
        int sum = 0;
        for(int i =1; i < len; ++i){
            int diff = prices[i] - prices[i-1];
            if(diff > 0){
                sum += diff;
            }
        }
        return sum;
    }

    public int maxProfit2(int[] prices) {
        int len = prices.length;
        if(len < 2) return 0;
        int[][] dp = new int[len][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        /**
         * 二维数组的 0 位代表 持有现金
         * 二维数组的 1 位代表 持有股票
         * 0 -> 1 -> 0 -> 1 -> 0 状态转移。
         */
        for (int i = 1; i < len; ++i) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }

        return dp[len-1][0];
    }

}
