package com.Solutions;


/**
 * 剑指 43
 * 从1～n的整数中， 1 出现的次数
 */
public class solution1871 {

    /**
     * 推导出来的三种情况，详情看leetcode1871题解释
     * @param n
     * @return
     */
    public int countDigitOne(int n) {
        int digit = 1;
        int res = 0;
        int high = n / 10;
        int cur = n % 10;
        int low = 0;
        while (high != 0 || cur != 0) {
            if(cur == 0) res += high * digit;
            else if(cur == 1) res += high * digit + low + 1;
            else res += (high + 1) * digit;
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return res;
    }
}
