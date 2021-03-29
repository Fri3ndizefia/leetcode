package com.Solutions;

import java.util.Arrays;

/**
 * DP篇
 * 小偷系列
 */
public class solution213 {
    public int rob(int[] nums) {
        /**
         * 只能偷 0, n-1
         * 或者偷 1, n
         * 要么不偷第一间
         * 要么不偷最后一间
         */
        int len = nums.length;
        if(len == 0) return 0;
        else if(len == 1) return nums[0];
        else if(len == 2) return Math.max(nums[0], nums[1]);
        int dp1[] = new int[len - 1]; // 偷第一
        int dp2[] = new int[len - 1]; // 偷末一
        System.arraycopy(nums, 0, dp1, 0, len - 1);
        System.arraycopy(nums, 1, dp2, 0, len - 1);
        int f1[] = new int[len - 1];
        int f2[] = new int[len - 1];
        f1[0] = dp1[0];
        f1[1] = Math.max(dp1[0], dp1[1]);
        f2[0] = dp2[0];
        f2[1] = Math.max(dp2[0], dp2[1]);
        for (int i = 2; i < len - 1; i++) {
            f1[i] = Math.max(f1[i - 2] + dp1[i], f1[i - 1]);
            f2[i] = Math.max(f2[i - 2] + dp2[i], f2[i - 1]);
        }
        return Math.max(f1[len - 2], f2[len - 2]);
    }

    public int rob2(int[] nums) {
        int len = nums.length;
        if(len == 0) return 0;
        else if(len == 1) return nums[0];
        else if(len == 2) return Math.max(nums[0], nums[1]);
        return Math.max(robPart(Arrays.copyOfRange(nums, 0, len - 1)),
                robPart(Arrays.copyOfRange(nums, 1, len)));

    }

    public int robPart(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1], nums[0]);
        for (int i = 2; i < len; ++i) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        return dp[len - 1];
    }

    /**
     *  变量滚动保存
     * @param nums
     * @return
     */
    public int robPart2(int[] nums) {
        int pre = 0, cur = 0, tmp;
        for(int num : nums) {
            tmp = cur;
            cur = Math.max(pre + num, cur);
            pre = tmp;
        }
        return cur;
    }
}
