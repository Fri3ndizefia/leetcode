package com.Solutions;

/**
 * DP篇
 * 股票系列
 * 剑指 63
 * 股票的最大利润
 */
public class solution1898 {

    /**
     * 先想好动态规划的搭建方程：
     * 第 i 天动规 是 第 i - 1天前所有的最大利润 和 第 i 天收益 进行对比
     * dp[i] = max(dp[i-1], i-minCost);
     *  minCost进行实时更新，随着遍历的时候，跟着更新
     *  第0天的最小花费是 prices[0]
     *  第0天的收益（动规）也是0，
     *
     *  最后在最前面加入一个当值是0的判断。
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int[] dp = new int[prices.length];
        dp[0] = 0;
        int cost = prices[0];
        for (int i = 1; i < prices.length; ++i) {
            cost = Math.min(prices[i], cost);
            dp[i] = Math.max(dp[i - 1], prices[i] - cost);
        }
        return dp[prices.length - 1];
    }
}
