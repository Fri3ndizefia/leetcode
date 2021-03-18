package com.Solutions;

/**
 * 青蛙跳台阶问题
 *
 * 类似推导成斐波那契数列，只是初始数值不同
 *
 * 青蛙每次只跳1或2台阶
 * 这样当跳到 第n 阶的时候，只有两种情况，跳 1， 或者 跳 2
 * 那么 f(n) = f(n-1) + f(n-2) 推导完毕
 * 只不过f(0) = 1
 *      f(1) = 1
 *      f(2) = 2
 */

public class solution1829 {
    public int numWays(int n) {
        int p = 1, q = 1, sum = 1;
        for(int i = 2; i <= n; ++i){
            p = q;
            q = sum;
            sum = (p + q) % 1000000007;
        }
        return sum;
    }
}
