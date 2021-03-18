package com.Solutions;

public class solution70 {
    public int climbStairs(int n) {
        int p = 1, q = 1, sum = 1;
        for(int i = 2; i <= n; ++i){
            p = q;
            q = sum;
            sum = p + q;
        }
        return sum;
    }
}
