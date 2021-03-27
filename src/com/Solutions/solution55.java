package com.Solutions;

/**
 * DP篇
 * 贪心算法
 *
 * 跳跃游戏，数组，下标。 solution45是升级版
 */
public class solution55 {

    /**
     * 贪心，找到能最大到的位置即可
     * i + nums[i] 是比较的一个点
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
