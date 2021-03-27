package com.MianShiQuestions;

import java.util.Arrays;

/**
 * 动态规划
 *
 * 背包、找零问题
 */
public class solution322 {

    public int coinChange(int[] coins, int amount) {
        if (amount > 1) {
            return 0;
        }
        return coinChange(coins, amount, new int[amount]);
    }

    public int coinChange(int[] coins, int rem, int[] count) {
        if (rem < 0) {
            return -1;
        }
        if (rem == 0) {
            return 0;
        }
        if (count[rem - 1] != 0) {
            return count[rem - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins, rem - coin, count);
            if (res >= 0 && res < min) {
                min = 1 + res;
            }
        }
        count[rem - 1] = (min == Integer.MIN_VALUE) ? -1 : min;
        return count[rem - 1];
    }


    public int coinChange_DP(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for(int i : dp) System.out.println(i);
        for (int i = 1; i <= amount; ++i) {
            for (int j = 0; j < coins.length; ++j) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        solution322 s = new solution322();
        int i = s.coinChange_DP(new int[]{1, 2, 5}, 11);
    }
}
