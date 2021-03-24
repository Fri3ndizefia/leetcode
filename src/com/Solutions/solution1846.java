package com.Solutions;

/**
 * 剑指 17
 * 打印从1到最大的n位数
 *
 * 在没有考虑大数相加的情况下，这道题就是个麻瓜
 */
public class solution1846 {
    public int[] printNumbers(int n) {
        int length = (int)Math.pow(10, n) - 1;
        int[] array = new int[length];
        for(int i = 0; i < length; ++i){
            array[i] = i+1;
        }
        return array;
    }
}
