package com.Solutions;

/**
 * 剑指 57
 * 和为s的两个数字
 *
 * 递增排序的数组 和 一个数字 s
 * 找出任意和为s的两数字
 */

public class solution1888 {


    /**
     * 不被考虑的
     * 暴力搜索法，直接超时，不解释。
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target){
        int[] res = new int[2];
        for (int i = 0; i < nums.length-1; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                if (nums[i] + nums[j] == target) {
                    res[0] = nums[i];
                    res[1] = nums[j];
                }
            }
        }
        return res;
    }


    /**
     * 对撞双指针法
     * 左指针指向最左端
     * 右指针指向最右端
     * sum 值小于target，左指针增加，sum值大于target，右指针减小。
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int s = nums[i] + nums[j];
            if (s > target) {
                --j;
            } else if (s < target) {
                ++i;
            } else{
                return new int[]{nums[i], nums[j]};
            }
        }
        return new int[0];
    }

    /**
     * 改良了判断条件，
     * 如果使用 sum = nums[i] + nums[j] 这种计算条件
     * 可能会存在大数值溢出，使用taget - nums[i] 再和nums[j]做比较会比较合理
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2_improved(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            if (target - nums[i] > nums[j]) {
                ++i;
            } else if (target - nums[i] < nums[j]) {
                --j;
            } else{
                return new int[]{nums[i], nums[j]};
            }
        }
        return new int[0];
    }

}
