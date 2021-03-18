package com.Solutions;

public class solution162 {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1 || nums[0] > nums[1]) {
            return 0;
        }
        if (nums[nums.length - 1] > nums[nums.length - 2]) {
            return nums.length - 1;
        }
        int index = 0;
        for (int i = 1; i < nums.length-1; ++i) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                index = i;
                break;
            }
        }
        return index;
    }

    public int linearScan(int[] nums) {
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i] > nums[i + 1]) {
                return i;
            }

        }
        return nums.length - 1;
    }

    public int binaryCombine(int[] nums) {
        return search(nums, 0, nums.length - 1);
    }

    public int search(int[] nums, int l, int r) {
        if (l == r) {
            return l;
        }
        int mid = (l + r) / 2;
        if (nums[mid] > nums[mid + 1]) {
            return search(nums, l, mid);
        }
        return search(nums, mid + 1, r);
    }
}
