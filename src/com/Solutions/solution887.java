package com.Solutions;

/**
 * 扔鸡蛋问题
 */

/**
 * 面试拓展问题：
 * 有 2个 鸡蛋 ，用一座100层的楼，需要最少多少次数测试 蛋会在 几层碎？
 * 问第一次在第几层扔？
 * 14层
 * 1+2+3+...+14 > 100
 * 第一次就扔第14层，碎了，就在1-13中扔。没碎，下次只有区间大小12，也就是15-26，所以扔27层。
 */
public class solution887 {
    public int calcF(int K, int T) {
        if(T == 1 || K == 1) return T + 1;
        return calcF(K - 1, T - 1) + calcF(K, T - 1);
    }

    public int superEggDrop(int K, int N) {
        int T = 1;
        while(calcF(K,T) < N+1) T++;
        return T;
    }

}
