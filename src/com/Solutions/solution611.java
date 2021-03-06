package com.Solutions;

import java.util.Arrays;

/***
 * 可构建几个三角形？
 *
 */
public class solution611 {
    /***
     * 无脑枚举法
     * 时间复杂度 O(N^3)
     * @param nums
     * @return
     */
    public int triangleNumber(int[] nums) {
        int ans=0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] <= nums[k] || nums[i] + nums[k] <= nums[j] || nums[j] + nums[k] <= nums[i]) {
                        continue;
                    }else{
                        ans++;
                    }
                }
            }
        }
        return 0;
    }

    /***
     * 排序后 二分查找法，排序后，必定会  a <= b <= c
     * 一旦满足  a + b > c 即可满足题意
     */
    public int triangleNumberBinarySearch(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans=0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] <= nums[k] || nums[i] + nums[k] <= nums[j] || nums[j] + nums[k] <= nums[i]) {
                        continue;
                    }else{
                        ans++;
                    }
                }
            }
        }
        return 0;
    }
}
