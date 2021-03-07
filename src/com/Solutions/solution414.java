package com.Solutions;

import java.util.Arrays;
import java.util.Collection;
import java.util.Stack;

public class solution414 {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int result = nums[nums.length - 1];
        int max = nums[nums.length - 1];
        int counter = 1;
        for (int i = nums.length - 1; i >= 0; --i) {
            if(nums[i] < result){
                max = result;
                result = nums[i];
                ++counter;
            }
            if (counter == 3) {
                max = nums[nums.length - 1];
                break;
            }
        }
        return max;
    }
}
