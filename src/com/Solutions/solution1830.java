package com.Solutions;

/**
 * 查找旋转数组的最小值
 * [3,4,5,1,2] 就是一个旋转数组，旋转出来时 1，2，3，4，5
 * 压缩一下时间复杂度找到这个最小值
 *
 * --二分查找--
 */
public class solution1830 {
    public int minArray(int[] numbers) {
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int pivot = low + high >>> 1;
            //或者用  low + (high-low)/2
            if (numbers[pivot] < numbers[high]) {
                high = pivot;
            } else if (numbers[pivot] > numbers[high]) {
                low = pivot + 1;
            }else{
                high = high-1;
            }
        }
        return numbers[low];
    }

}
