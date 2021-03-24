package com.Solutions;

/**
 * 剑指 39
 * 数组中出现次数超过一半的数字
 * 摩尔投票法
 */
public class solution1867 {

    public int majority(int[] nums) {
        Integer candidate = null;
        int count = 0;
        for (int i : nums) {
            if (count == 0) {
                candidate = i;
            }
            count += candidate == i ? 1 : -1;
        }
        return candidate;
    }
}
