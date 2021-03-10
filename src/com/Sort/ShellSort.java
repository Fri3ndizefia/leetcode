package com.Sort;

/**
 * 插入排序的优化
 * 插入排序的交换次数比较多，而希尔排序通过带间隔的使用插入排序。直到最后间隔为1的时候，就是标准的插入排序了。此时数组几乎有序
 */
public class ShellSort {

    public int[] sortArray(int[] nums) {
        int len = nums.length;
        int h = 1;

        // 使用 Knuth 增量序列
        // 找增量的最大值
        while (3 * h + 1 < len) {
            h = 3 * h +1;
        }

        while (h >= 1) {
            // insertion sort
            for (int i = h; i < len; ++i) {
                insertionForDelta(nums, h, i);
            }
            h = h / 3;
        }

        return nums;
    }

    private void insertionForDelta(int[] nums, int gap, int i) {
        int temp = nums[i];
        int j = 1;
        while (j >= gap && nums[j - gap] > temp) {
            nums[j] = nums[j - gap];
            j -= gap;
        }
        nums[j] = temp;
    }
}
