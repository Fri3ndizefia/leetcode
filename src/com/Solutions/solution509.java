package com.Solutions;

/**
 * 斐波那契数列
 * f(0) = 0
 * f(2) = f(1) = 1;
 * f(n) = f(n-1) + f(n-2);
 */
public class solution509 {
    public int fibRecursion(int n){
        if (n == 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        }
        return fibRecursion(n - 1) + fibRecursion(n - 2);
    }

    /**
     * 通项公式法
     */
    public int fibExpression(int n) {
        return (int) ((int) Math.round(1 / Math.sqrt(5)) * (Math.pow((1 + Math.sqrt(5)) / 2, n) - Math.pow((1 - Math.sqrt(5)) / 2, n)));
    }

    /**
     * 动态规划
     * 滚动数组法
     */
    public int fibArray(int n) {
        if(n < 2)
            return n;
        int p = 0, q = 0, r = 1;
        /**
         * r代表f(n)，p，q代表n-1，n-2这样的
         */
        for (int i = 2; i <= n; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
        //滚动过去
    }
}
