package com.Solutions;

/**
 * 整数拆分
 * 给定一个正整数n，将其拆分为 至少 两个正整数的和，并使这些整数的乘积最大化
 * 返回可以获得最大的乘积
 */
public class solution343 {

    /**
     * 动态规划方法 时间复杂度 n^2
     * n = 1 的时候，答案是1
     * n = 2 的时候，拆分乘积最大还是 1
     * n = 3 的时候 2*1 最大是2
     * n = 4 的时候 进行比较1*3， 2*2？
     *
     * dp[i] 将i的拆分乘积最大和保存起来
     * 到了下一次 新的数 i 的时候
     * 从 1 -> i 赋值j
     * j*dp[i-j] 作为比较一项
     * j*(i-j) 作为比较一项
     * 两者最大留下 存为 curMax
     * 同时每一次都有比较，所以 curMax和上面的最大值也要进行比较
     * 综合得出到的curMax才是最终最大值
     *
     *
     * i-j 是一个整数形式
     * dp[i-j] 是一个整数的dp形式，也就是这个i-j的拆分乘积最大
     * @param n
     * @return
     */
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; ++i) {
            int curMax = 0;
            for (int j = 1; j < i; ++j) {
                curMax = Math.max(curMax, Math.max(j * (i - j), j * dp[i - j]));
            }
            dp[i] = curMax;
        }
        return dp[n];
    }

    /**
     * 数学推论发=法
     * 一些数学推论
     * 推论一：若拆分的数量a确定，则 各拆分数字相等时，乘积最大
     * 推论二：将数组n尽可能以因子3等分时，乘积最大
     */
    public int integerBreak2(int n) {
        if( n <= 3) return n - 1;
        int a = n / 3;
        int b = n % 3;
        if(b == 0) return (int) Math.pow(3, a);
        if(b == 1) return (int) Math.pow(3, a - 1) * 4;
        return (int)Math.pow(3,a) * 2;
    }
}
