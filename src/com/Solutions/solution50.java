package com.Solutions;

/**
 * 快速求幂
 * 第一种：使用递归
 *  分治法 ， 奇数情况下，多乘一次自己，偶数情况下，不变
 *
 * 第二种：使用迭代
 *  给出结论：x^n 的结果，是 n 的二进制对应下的 1的 所对应的指数
 */
public class solution50 {

    public double quickMul(double x, long N){
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }

    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    /**
     * 迭代法
     */
    public double quickMult(double x, long N) {
        double ans = 1.0;
        double x_contribute = x;

        while (N > 0) {
            if (N % 2 == 1) {
                ans *= x_contribute;
            }
            x_contribute *= x_contribute;
            N /= 2;
        }
        return ans;
    }
}
