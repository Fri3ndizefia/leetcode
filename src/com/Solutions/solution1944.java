package com.Solutions;

/**
 * 递归乘法问题
 *
 */

public class solution1944 {
    public int multiple(int A, int B) {
        boolean negativeFlag = B < 0 && (B % 2 != 0);
        int res = 0;
        for (int i = 0; i < Math.abs(B); ++i) {
            res += A;
        }
        return negativeFlag ? (-res) : res;
    }
}
