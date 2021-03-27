package com.Solutions;

/**
 * 长度最小的连续的子数组
 */
public class solution209 {


    /**
     * 暴力的搜索法
     * 时间复杂度是n^2
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int sum;
        for (int i = 0; i < nums.length; ++i) {
            sum = 0;
            for (int j = i; j < nums.length; ++j) {
                sum += nums[j];
                if (sum >= target) {
                    ans = Math.min(ans, j - i + 1);
                    break;
                }
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }


    /**
     * 时间复杂度是 n
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen2(int target, int[] nums) {
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        int slow = 0;
        int fast = 0;
        int n = nums.length;
        while (fast < n) {
            sum += nums[slow];
            while (sum >= target) {
                ans = Math.min(ans, fast - slow + 1);
                sum -= nums[slow];
                ++slow;
            }
            fast ++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
