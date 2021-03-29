package com.Solutions;

import java.util.Arrays;

/**
 * 剑指 45
 */
public class solution1878 {
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            strs[i] = String.valueOf(nums[i]);
        }
        quickSort(strs, 0, strs.length - 1);
        StringBuilder res = new StringBuilder();
        for (String s : strs) {
            res.append(s);
        }
        return res.toString();
    }

    private void quickSort(String[] strs, int left, int right) {
        if(left >= right) return;
        int i = left, j = right;
        String tmp = strs[i];
        while (i < j) {
            while ((strs[j] + strs[left]).compareTo(strs[left] + strs[j]) >= 0 && (i < j)) {
                --j;
            }
            while ((strs[i] + strs[left]).compareTo(strs[left] + strs[i]) <= 0 && (i < j)) {
                ++i;
            }
            tmp = strs[i];
            strs[i] = strs[j];
            strs[j] = tmp;
        }
        strs[i] = strs[left];
        strs[left] = tmp;
        quickSort(strs, left, i - 1);
        quickSort(strs, i + 1, right);
    }

    /**
     * 改写排序规则
     */
    public String minNumber2(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder res = new StringBuilder();
        for (String s : strs) {
            res.append(s);
        }
        return res.toString();
    }
}
