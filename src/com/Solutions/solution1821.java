package com.Solutions;

/**
 * LCP17 速算机器人
 */

public class solution1821 {
    public int calculate(String s) {
        int X=1;
        int Y=0;
        for (char c : s.toCharArray()) {
            if(c=='A') X = 2 * X + Y;
            else if(c=='B') Y = 2 * Y + X;
        }
        return X+Y;
    }

    public int calculate2(String s) {
        return 1 << s.length();
    }
}
