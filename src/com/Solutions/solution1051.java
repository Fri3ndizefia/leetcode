package com.Solutions;

import java.util.Arrays;

public class solution1051 {
    /***
     * 通过排序，然后找到不同的点，记录有多少个不同，就是移动了多少次
     * @param nums
     * @return
     */
    public static int insertionSort(int[] nums) {
        int[] source = nums.clone();
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (source[i] != nums[i]) {
                ++ans;
            }
        }
        return ans;
    }
}
