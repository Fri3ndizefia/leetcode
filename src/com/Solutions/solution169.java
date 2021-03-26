package com.Solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 摩尔投票
 * 多数元素
 */
public class    solution169 {
    public int majorityElement(int[] nums) {
        int major = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (int i : map.keySet()) {
            if (map.get(i) >= major) {
                return i;
            }
        }
        return -1;
    }

    public int sortMethod(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }


    /**
     * Boyer-
     * Moore 投票算法
     * candidate 候选众数
     * count 计数器
     * 当count为0的时候，下次遍历到的数就会让 candidate 等于 它
     * 遍历 数 等于 candidate， count++
     * 遍历 数 不等于 candidate，count--
     * 最终count对应的数就是众数
     *
     * https://leetcode-cn.com/problems/majority-element/solution/duo-shu-yuan-su-by-leetcode-solution/
     * @param nums
     * @return
     */
    public int moore(int[] nums) {
        Integer candidate = null;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += candidate == num ? 1 : -1;

        }
        return candidate;
    }
}
