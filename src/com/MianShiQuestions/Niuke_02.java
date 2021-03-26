package com.MianShiQuestions;

/**
 * 请实现有重复数字的升序数组的二分查找。
 * 输出在数组中第一个大于等于查找值的位置，如果数组中不存在这样的数(指不存在大于等于查找值的数)，则输出数组长度加一。
 *
 * https://www.nowcoder.com/practice/7bc4a1c7c371425d9faa9d1b511fe193?tpId=0&tqId=0&tab=answerKey
 */
public class Niuke_02 {
    public int upper_bound_ (int n, int v, int[] a) {
        // write code here
        int mid = n >> 1;
        int low = 0;
        int high = n-1;
        int res = Integer.MAX_VALUE;
        while(low < high){
            mid = high + low >> 1;
            if(a[mid] < v){
                low = mid + 1;
            }else{
                high = mid - 1;
                res = Math.min(mid,res);
            }
        }
        if(high == n-1) return n + 1;
        else if(high == 0) return 1;
        if(high > 0 && a[high] >= v) return high + 1;
        else return res + 1;
    }
}
