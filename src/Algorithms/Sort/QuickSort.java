package Algorithms.Sort;

import java.util.Random;

/***
 * 也叫做分区交换排序（partition-exchange sort）
 * O(nlogn)   worst O(n^2)
 *
 */
public class QuickSort {
    /**
     * 快速排序 1： 基本快速排序
     */
    /**
     * 列表大于等于7的时候，优先使用插入排序提高效率
     */
    private static final int INSERTION_SORT_THRESHOLD = 7;
    private static final Random RANDOM = new Random();

    public static int[] sortArray(int[] nums) {
        int len = nums.length;
        quickSort(nums, 0, len - 1);
        return nums;
    }

    private static void quickSort(int[] nums, int left, int right) {
        //针对小区间，使用插入排序
        if (right - left >= INSERTION_SORT_THRESHOLD) {
            insertionSort(nums, left, right);
            return;
        }

        int pIndex = partition(nums, left, right);
        quickSort(nums, left, pIndex - 1);
        quickSort(nums, pIndex + 1, right);
    }

    private static void insertionSort(int[] nums, int left, int right) {
        for (int i = left + 1; i <= right; ++i) {
            int temp = nums[i];
            int j = i;
            while (j > left && nums[j - 1] > temp) {
                nums[j] = nums[j - 1];
                --j;
            }
            nums[j] = temp;
        }
    }

    private static int partition(int[] nums, int left, int right) {
        int randomIndex = RANDOM.nextInt(right - left + 1) + left;
        swap(nums, left, randomIndex);

        //定一个基准值
        int pivot = nums[left];
        int lt = left;

        //循环不变量
        // all in  [left+1, lt] < pivot
        // all in  [lt+1, i) >= pivot
        for (int i = left + 1; i <= right; ++i) {
            if (nums[i] < pivot) {
                lt++;
                swap(nums, i, lt);
            }
        }
        swap(nums, left, lt);
        return lt;
    }

    private static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    /**
     * 针对重复元素多的情况下的
     * 快速排序2： 双指针碰撞排序
     * https://leetcode-cn.com/problems/sort-an-array/solution/fu-xi-ji-chu-pai-xu-suan-fa-java-by-liweiwei1419/
     */
    /**
     * 快速排序3：三指针排序
     */

    public static void main(String[] args) {
        int[] array = { 1, 5,32,4,53,3,7,8,76,3,43};
        for(int i : sortArray(array)) System.out.println(i);
    }
}
