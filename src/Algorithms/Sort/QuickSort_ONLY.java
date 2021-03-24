package Algorithms.Sort;

public class QuickSort_ONLY {
    public static void quickSort(int[] nums, int n ) {
        quickSortRecursive(nums, 0, n - 1);
    }

    public static void quickSortRecursive(int[] nums, int i, int j) {
        if (i >= j) {
            return;
        }

        /**
         * 先从整个数组中，分出两部分，一部分是小于pivot值，一部分是大于pivot值的
         * 这里的方法，默认将 数组的最后一位设置为pivot基准值了
         */
        int q = partition(nums, i, j);
        /**
         * 比如第一次，q是分好组的位置，对应的情况是
         * [ 小于pivot, pivot, 大于等于pivot]
         * 这个时候，pivot所在的index就是 q
         */
        /**
         * 对小于pivot的区域进行快速排序
         */
        quickSortRecursive(nums, i, q - 1);
        /**
         * 对大于等于pivot的区域进行快速排序
         */
        quickSortRecursive(nums, q + 1, j);
    }

    private static int partition(int[] nums, int i, int j) {
        // 右边为基准点 pivot
        int pivot = nums[j];
        // 从分区的左边 i 开始作为tempLocation
        int tempLocation = i;
        /**
         * 当从 i -> j 的数组中遍历到一个比 pivot 小的数字
         * 就将它和tempLocation换位置，也就是放到左边
         * 同时tempLocation加一，作为下一次的集合所有 小于 pivot的数值用
         */
        for (int n = i; n < j; ++n) {
            if(nums[n]<pivot){
                int temp = nums[tempLocation];
                nums[tempLocation] = nums[n];
                nums[n] = temp;
                ++tempLocation;
            }
        }

        /**
         * 最后 tempLocation 所在的位置是所有小于pivot值的后一位
         * [ 小于, (tempLocation,) 大于等于pivot，pivot];
         * 再将pivot和tempLocation互换位置
         * 得到结果
         * [ 小于pivot, pivot, 大于等于pivot]
         */
        int temp = nums[tempLocation];
        nums[tempLocation] = nums[j];
        nums[j] = temp;

        /**
         * 返回tempLocation，也就是pivot位置
         */
        return tempLocation;
    }

    public static void main(String[] args){
        int[] array = {63,81,43,54,37,84,45,97,50,87};
        quickSort(array, 10);
        for(int i : array) System.out.println(i);
    }
}
