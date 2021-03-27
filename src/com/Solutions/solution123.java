package com.Solutions;

/**
 * DP篇
 * 股票交易系列
 * 两次交易
 */
public class solution123 {
    public int maxProfit(int[] prices) {
        /**
         * 在任意一个 i 天的情况， 有五种状态
         * 1。   什么都没做
         * 2。   只进行了一次买 buy1
         * 3。   只进行了一次买卖 sell1
         * 4。   进行了一次买卖，第二次买。 buy2
         * 5。   进行了两次买卖。 sell2
         *
         * 要理解 buy 记录的数据是负数，sell是正数
         * 任何一个时刻，状态转移的方程式
         * buy1 = max(buy1', -prices[i]); 花更少的钱去买（ -2 > -10），获得更小负数
         * sell1 = max(sell1', prices[i] + buy1'); 买卖操作，找到最大一次买卖区间
         * buy2 = max(buy2', -prices[i]); 同样找到第二次买股的最便宜价格
         * sell2 = max(sell2', prices[i] + buy2')
         *
         */
        int buy1 = -prices[0], sell1 = 0;
        int buy2 = -prices[0], sell2 = 0;
        for (int i = 1; i < prices.length; ++i) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, prices[i] + buy1);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }
}
