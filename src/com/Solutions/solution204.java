package com.Solutions;

import java.util.Arrays;

/**
 * 判断质数
 * 大于1才开始算是否是质数，因为能被 1 和 他本身整除
 * 简单方法从2开始遍历， n % i == 0?
 * 简单算法可以用
 *
 */
public class solution204 {
    /**
     * 效率最低
     */
    public static boolean isPrimeNumber(int n){
        if (n <= 3) {
            return n>1;
        }
        for (int i = 2; i < n; ++i) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * sqrt 优化
     */
    public static boolean isPrimeNumberBySqrt(int n){
        if (n <= 3) {
            return n > 1;
        }
        for (int i = 2; i <= (int) Math.sqrt(n); ++i) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 再优化
     * 质数的特点，总是 6x-1 或者 6x+1
     */
    public static boolean isPrime(int n){
        if (n <= 3) {
            return n > 1;
        }

        // 不在6的两侧的一定不是质数
        if (n % 6 != 1 && n % 6 != 5) {
            return false;
        }

        int sqrt = (int) Math.sqrt(n);
        for (int i = 5; i <= sqrt; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    public int countPrimes(int n) {
        if(n<=1){
            return 0;
        }
        int sum = 0;
        for(int i = 2; i< n; ++i ){
            sum += isPrime(i) ? 1: 0;
        }
        return sum;
    }

    /**
     * 埃氏筛
     * 如果 x 是 质数，那么 2x 3x 4x...都不是质数，标记为0
     * 当然这里还可以继续优化，对于一个质数 x，如果按上文说的我们从 2x 开始标记其实是冗余的，应该直接从 x⋅x 开始标记，
     * 因为 2x,3x… 这些数一定在 xx 之前就被其他数的倍数标记过了，例如 22 的所有倍数，33 的所有倍数等。
     */

    public int countPrimesE(int n) {
        int[] isPrime =  new int[n];
        Arrays.fill(isPrime, 1);
        int ans = 0;
        for (int i = 2; i < n; ++i) {
            if (isPrime[i] == 1) {
                ++ans;
                if ((long) i * i < n) {
                    for (int j = i * i; j < n; j += i) { //从 xx 开始， xx， （x+1）x， （x+2）x，减少冗余量，因为 2 ，3，4，5自然有，2，3，4解决
                        isPrime[j] = 0;
                    }
                }
            }
        }
        return ans;
    }
}
