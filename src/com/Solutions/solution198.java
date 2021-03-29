package com.Solutions;

/**
 * DP篇
 * 小偷系列
 */
public class solution198 {
    public int rob(int[] nums) {
        /**
         * 不可以偷连续房子的钱
         * f[i] = f[i-2] + nums[i] + f[i-1]
         */
        int len = nums.length;
        if(nums.length == 0) return 0;
        else if(nums.length == 1) return nums[0];
        else if(nums.length == 2) return Math.max(nums[0], nums[1]);
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1], nums[0]);
        for (int i = 2; i < len; ++i) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        return dp[len - 1];
    }
}
