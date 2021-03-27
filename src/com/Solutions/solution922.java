package com.Solutions;

public class solution922 {

    /**
     * 双指针法
     * @param nums
     * @return
     */
    public int[] sortArrayByParity(int[] nums) {
        int n = nums.length;
        int j = 1;
        for (int i = 0; i < n; i += 2) {
            if (nums[i] % 2 == 1) {
                while (nums[j] % 2 == 1) {
                    j += 2;
                }
                nums[i] ^= nums[j];
                nums[j] ^= nums[i];
                nums[i] ^= nums[j];
            }
        }
        return nums;
    }
}
