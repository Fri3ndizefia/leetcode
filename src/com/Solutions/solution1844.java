package com.Solutions;

/**
 * 剑指 15
 * 二进制中 1 的个数?
 */
public class solution1844 {


    /**
     * 位运算法
     * res是计数器
     * 0000 1010
     * 位与操作 1，就是0
     * 0000 1011
     * 位与操作 1，就是1
     * 是和最后一位进行比较
     * 每次比较，都要位右移1，也就是 n >>>= 1；
     * @param n
     * @return
     */
    public int hamming(int n) {
        int res = 0;
        while (n != 0) {
            res += n&1;
            n >>>= 1;
        }
        return res;
    }

    public int hamming2(int n) {
        int res = 0;
        while (n != 0) {
            ++res;
            n &= n-1;
        }
        return res;
    }

    /**
     * 调用函数法
     * @param n
     * @return
     */
    public int hammingWeight(int n){
        return Integer.bitCount(n);
    }
}
