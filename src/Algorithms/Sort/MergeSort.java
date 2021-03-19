package Algorithms.Sort;

/**
 * 归并排序
 * 分治法
 */
public class MergeSort {
    /**
     * 列表大小等于或小于该大小，就优先使用 插入排序，否则使用 归并排序
     */
    private final static int INSERTION_SORT_THRESHOLD = 7;

    public int[] sortArray(int[] nums) {
        int len = nums.length;
        int[] temp = new int[len];
        mergeSort(nums, 0, len - 1, temp);
        return nums;
    }

    /**
     * 对数组 nums 的子区间 left right 进行归并排序
     * @param nums
     * @param left
     * @param right
     * @param temp
     */

    private void mergeSort(int[] nums, int left, int right, int[] temp) {
        //如果是区间比较小，就使用插入排序
        if (right - left <= INSERTION_SORT_THRESHOLD) {
            insertionSort(nums, left, right);
        }

        int mid = left + (right-left)/2;
        /**
         * Java有更好的写法，面对大整数用的
         * int mid = (left+right) >>> 1;
         */
        mergeSort(nums, left, mid, temp);
        mergeSort(nums, mid + 1, right, temp);
        if (nums[mid] <= nums[mid + 1]) {
            return;
        }
        mergeOfTwoSortedArray(nums, left, mid, right, temp);
    }

    /**
     * 插入排序
     * @param nums 数组
     * @param left 左边界
     * @param right 右边界
     */

    private void insertionSort(int[] nums, int left, int right) {
        for (int i = left + 1; i < right; ++i) {
            int temp = nums[i];
            int j = i;
            while (j > 0 && nums[j] > temp) {
                nums[j] = nums[j - 1];
                --j;
            }
            nums[j] = temp;
        }
    }

    /**
     * 合并两个数组，先把值给复制到临时数组中，再合并进去
     * @param nums
     * @param left
     * @param mid
     * @param right
     * @param temp 全局使用的临时数组
     */
    private void mergeOfTwoSortedArray(int[] nums, int left, int mid, int right, int[] temp) {
        System.arraycopy(nums, left, temp, left, right + 1 - left);

        int i = left;
        int j = mid + 1;

        for (int k = left; k <= right; ++k) {
            if (i == mid + 1) {
                nums[k] = temp[j];
                ++j;
            } else if (j == right + 1) {
                nums[k] = temp[i];
                ++i;
            } else if (temp[i] <= temp[j]) {
                nums[k] = temp[i];
                ++i;
            } else{
                // temp[i] > temp[j]
                nums[k] = temp[j];
                ++j;
            }
        }
    }
}
