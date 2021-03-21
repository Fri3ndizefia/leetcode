package com.Solutions;

import java.util.HashSet;
import java.util.Set;

public class solution287 {
    public int find(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (!set.add(i)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 快慢指针法
     * @param nums
     * @return
     */
    public int find2(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    /**
     * 分桶法
     */
    public int find3(int[] nums) {
        int[] bucked = new int[nums.length];
        for (int i : nums) {
            bucked[i]++;
            if (bucked[i] > 1) {
                return i;
            }
        }
        return -1;
    }
}
