package com.Solutions;

import java.util.Arrays;

/**
 * 检查数组是否经过排序和翻转得到?
 */

public class solution1752 {
    /**
     *
     */
    public boolean check(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int firstDiffIndex = 1;
        while (firstDiffIndex < nums.length) {
            if(nums[firstDiffIndex] < nums[firstDiffIndex]){
                break;
            }else{
                ++firstDiffIndex;
            }
        }
        if (firstDiffIndex == nums.length - 1) {
            return true;
        } else{
            int[] temp = new int[nums.length];
            System.arraycopy(nums, 0, temp, 0, nums.length);
            Arrays.sort(temp);
            for (int i = 0; i < nums.length; ++i) {
                if (firstDiffIndex == nums.length - 1) {
                    firstDiffIndex = 0;
                }
                if (temp[i] != nums[firstDiffIndex]) {
                    return false;
                }
                ++firstDiffIndex;
            }
            return true;
        }
    }


    public boolean check2(int[] nums) {
        int n = nums.length;
        //有经过轮转
        boolean isCount = nums[0] >= nums[n-1];

        for(int i=1;i<n;i++){

            if(nums[i]<nums[i-1]){
                if(isCount){
                    isCount = false;
                }else{
                    return false;
                }
            }

        }
        return true;
    }

}
