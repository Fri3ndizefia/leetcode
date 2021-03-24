package com.Solutions;

import java.util.Arrays;
import java.util.Collections;

/**
 * 剑指 42
 * 连续子数组的最大和
 */
public class solution1870 {

    /**
     * 暴力搜索，时间复杂度 N^2
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum = 0;
            for (int j = i; j < nums.length; ++j) {
                sum += nums[j];
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    /**
     * 动态规划
     * 时间复杂度 N
     * 空间复杂度 M或者1
     * dp[0] = nums[0]
     * 连续子数组的最大和，可以联想到 连续正数 的子数组相加
     * 再扩大一点，子数组可以允许有负数参加
     * 然后规范思考：
     * dp[i] = dp[i-1] + nums[i] 如果前面dp和是正数，就加上 dp[i-1] > 0
     * dp[i] = nums[i] 如果前面的dp和已经是负数了，就不要，只存当前数字
     * 每一步都这么想，经过这样筛选出来的dp数组
     * 每一项都代表了是 当前 i 做结尾的子数组的最大和
     * 返回dp数组最大值即可
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            if (dp[i - 1] <= 0) {
                dp[i] = nums[i];
            }else{
                dp[i] = dp[i - 1] + nums[i];
            }
        }
        Arrays.sort(dp);
        return dp[dp.length - 1];
    }

    /**
     * 原地动态规划
     * 反正前面的数值也不需要用到了，就将数组进行更改即可。
     * 每一项的要么是加前一项的dp和（dp > 0），要么就是保存其自身。
     * @param nums
     * @return
     */
    public int maxSubArrayPlus(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            nums[i] += Math.max(nums[i - 1], 0);
            res = Math.max(res, nums[i]);
        }
        return res;
    }
}
