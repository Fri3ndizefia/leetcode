package com.Solutions;

import java.util.ArrayList;
import java.util.List;

public class solution1313 {
    public int[] decompressRLElist(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i += 2) {
            for (int j = 0; j < nums[i]; ++j) {
                list.add(nums[i + 1]);
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; ++i) {
            result[i] = list.get(i);
        }
        return list.stream().mapToInt(i->i).toArray(); // 这个方法耗时很长
    }
}
