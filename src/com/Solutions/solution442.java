package com.Solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 寻找重复了的数字
 *
 *
 */

public class solution442 {
    public List<Integer> find(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (int i : map.keySet()) {
            if (map.get(i) > 1) {
                list.add(i);
            }
        }
        return list;
    }

    /**
     * 原地哈希法
     * @param nums
     * @return
     */
    public List<Integer> find2(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i]) - 1;

            if (nums[index] < 0) {
                result.add(Math.abs(nums[i]));
                continue;
            }
            nums[index] = -nums[index];
        }

        return result;
    }
}
