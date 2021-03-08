package com.Solutions;

import java.util.Arrays;

/**
 * 寻找缺失的数字
 *
 */
public class solution268 {
    public int missingNumber(int[] nums) {
        int[] array = new int[nums.length + 1];
        Arrays.fill(array, 0);
        for(int i : nums){
            array[i]++;
        }
        int missing = 0;
        for(int i = 0; i < array.length; ++i){
            if(array[i] == 0){
                missing = i;
            }
        }
        return missing;
    }
}
