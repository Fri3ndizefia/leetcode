package com.Sort;

/*
插入排序

5 2 3 4 6
第一次不变
5 2 3 4 6
第二次开始， index为1 的数，一个一个和前面进行对比，小的话，交换
2 5 3 4 6
第三次开始， index为2 的数，插入到比它小的前面，比它大的后面
2 3 5 4 6
2 3 4 5 6
2 3 4 5 6

 */
public class InsertionSort {

    public static int[] insertionSorting(int[] nums) {
        if (nums.length == 0) {
            return nums;
        }
        for (int i = 1; i < nums.length; ++i) {
            int temp = nums[i];
            int j = i;
            while (j > 0 && nums[j - 1] > temp) {
                nums[j] = nums[j-1];
                --j;
            }
            nums[j] = temp;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] array = {2,3,4,5,2,6,2,1,1,7};
        for (int i : insertionSorting(array)) {
            System.out.println(i);
        }
    }
}
