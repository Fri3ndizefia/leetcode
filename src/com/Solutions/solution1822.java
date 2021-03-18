package com.Solutions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 剑指03 数组中重复的数字
 */
public class solution1822 {
    // 利用哈希集合解决
    public int findRepeat(int[] nums) {
        Set<Integer> map = new HashSet<Integer>();
        for(int i : nums){
            if(!map.add(i)) return i;
        }
        return -1;
    }

    // 占用很多内存的解决办法
    public int findRepeat1(int[] nums) {
        int[] array = new int[100000];
        for (int i : nums) {
            if (array[i] == 1) {
                return i;
            } else{
                array[i] = 1;
            }
        }
        return -1;
    }


}
