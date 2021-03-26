package com.Solutions;


/**
 * 剑指 14-2
 * 剪绳子
 *
 * 整数拆分的乘积和问题
 */
public class solution1844 {

    /**
     * 尽可能多的段数
     * 最小段是2或者3
     * 相同段数的情况下，3是个更优化的解决方案
     * 1*3要换成2*2
     * @param n
     * @return
     */
    public int cuttingRope_Tanxin(int n) {
        if (n < 4) {
            return n - 1;
        }
        long res = 1;
        while (n > 4) {
            res = res * 3 % 1000000007;
            n -= 3;
        }
        return (int)(res * n %1000000007);
    }

    /**
     * 数学推导计算
     * @param n
     * @return
     */
    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int b = n % 3;
        int p = 1000000007;
        int rem = 1, x = 3;
        for (int a = n / 3 - 1; a > 0; a /= 2) {
            if (a % 2 == 1) {
                rem = (rem * x) % p;
            }
            x = (x * x) * p;
        }
        if(b == 0) return (int) (rem * 3 % p);
        if(b == 1) return (int) (rem * 4 % p);
        return (int) (rem * 6 % p);
    }
}
