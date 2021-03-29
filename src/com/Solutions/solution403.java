package com.Solutions;

public class solution403 {
    public boolean canCross(int[] stones) {
        int len = stones.length;
        if (stones[1] != 1) {
            return false;
        }

        boolean[][] dp = new boolean[len][len + 1];
        dp[0][0] = true;
        for (int i = 1; i < len; ++i) {
            for (int j = 0; j < i; j++) {
                int k = stones[i] - stones[j];
                /**
                 * 这个判断？
                 * 因为其他石头跳到第i个石头，必须满足 k <= i
                 * 第 i 个石头能跳的最大步数是 i + 1，就意味着其他石头 j 跳到 第i个石头的最大步数
                 * 要么是 i，或者j+1
                 * 这个k 是其他石头跳到i石头上来的，所以 k <= i（或者 k<=j+1)
                 */
                if (k <= i) {
                    dp[i][k] = dp[j][k - 1] || dp[j][k] || dp[j][k + 1];
                    if (i == len - 1 && dp[i][k]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
