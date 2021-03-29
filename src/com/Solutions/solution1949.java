package com.Solutions;

/**
 * 爬楼梯问题
 *
 * 1、2、3阶级
 */

public class solution1949 {
    public int waysToStep(int n) {
        /**
         * 三步问题
         * 1,2,3
         * dp[i] = dp[i-1] + dp[i-2] + dp[i-3]?
         */
        if(n == 0) return 0;
        else if (n == 1) return 1;
        else if (n == 2) return 2;
        else if(n ==3) return 4;

        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 4;
        for (int i = 3; i < n; ++i) {
            dp[i] = ((dp[i-1] + dp[i-2]) % 1000000007 + dp[i-3]) %1000000007;
        }
        return dp[n - 1];
    }
}
