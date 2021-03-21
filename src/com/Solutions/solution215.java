package com.Solutions;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 一个TOP K 问题
 * 返回第K大的数
 */

public class solution215 {
    /**
     * 看起来很简单，问题就在于这个 快排
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    /**
     * 优先队列，在for循环中，如果size大于k，就poll出去小顶堆中最小的一个。
     * 整个for循环下来，就是k个数的小顶堆，堆顶就是第K大的数
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int num : nums) {
            heap.add(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.peek();
    }

    public int findKthLargest2(int[] nums, int k) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;

        int target = len - k;

        while (true) {
            int index = partition(nums, left, right);
            if (index == target) {
                return nums[target];
            } else if (index < target) {
                left = index + 1;
            } else{
                right = index - 1;
            }
        }
    }

    public int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int j = left;
        for (int i = left + 1; i <= right; ++i) {
            if(nums[i] < pivot){
                // 小于 pivot 的元素都被交换到前面
                ++j;
                swap(nums, j, i);
            }
        }
        // 在之前遍历的过程中，满足【left+1，j】 < pivot, 并且 (j, i] >= pivot
        swap(nums, j, left);
        // 交换以后， [left, j-1] < pivot    nums[j] = pivot    [j+1, right] >= pivot
        return j;
    }


    public void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
