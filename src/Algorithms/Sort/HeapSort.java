package Algorithms.Sort;

import java.util.Arrays;

/**
 * 堆排序是对选择排序的一个优化
 * 选择排序是对未排定的部分通过擂台一样的方法把最大值选出来，时间复杂度是 N
 * 堆排序则是构建了一个堆，这样可以以 logN 的时间复杂度选出最大元素
 *
 * 时间复杂度是 NlogN
 * 空间复杂度是 1
 */

public class HeapSort {

    public static void main(String []args){
        HeapSort hs = new HeapSort();
        int []arr = {9,8,7,6,5,4,3,2,1};
        hs.sortArray(arr);
        System.out.println(Arrays.toString(arr));
    }

    public int[] sortArray(int[] nums){
        int len = nums.length;
        heapify(nums); // 第一步创建大顶堆

        for (int i = len - 1; i >= 1; ) {
            swap(nums, 0, i);
            i--;
            shiftDown(nums, 0, i);
        }
        return nums;
    }

    /**
     * 将数组整理成堆
     * @param nums
     */
    private void heapify(int[] nums) {
        int len = nums.length;
        // 只需要从 i = len - 1 / 2 这个位置开始逐层下移
        for (int i = (len - 1) / 2; i >= 0; --i) {
            shiftDown(nums, i, len - 1);
        }
    }

    private void shiftDown(int[] nums, int k, int end) {
        while (2 * k + 1 <= end) {
            int j = 2 * k + 1;
            if (j + 1 <= end && nums[j + 1] > nums[j]) {
                ++j;
            }
            if (nums[j] > nums[k]) {
                swap(nums, j, k);
            }else{
                break;
            }
            k = j;
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        nums[index1] ^= nums[index2];
        nums[index2] ^= nums[index1];
        nums[index1] ^= nums[index2];
    }
}
