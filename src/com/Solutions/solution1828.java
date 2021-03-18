package com.Solutions;

/**
 * 斐波那契数列
 */
public class solution1828 {
    public int fib(int n) {
        if(n < 2)
            return n;
        int p = 0, q = 0, r = 1;
        /**
         * r代表f(n)，p，q代表n-1，n-2这样的
         */
        for (int i = 2; i <= n; i++) {
            p = q;
            q = r;
            r = (p + q) % 1000000007;
        }
        return r;
    }
}
