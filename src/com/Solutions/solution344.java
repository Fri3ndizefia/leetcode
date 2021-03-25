package com.Solutions;

public class solution344 {
    public void reverseString(char[] s) {
        int len = s.length;
        for (int i = 0; i < s.length >> 1; ++i) {
            s[i] ^= s[len - 1 - i];
            s[len-1-i] ^= s[i];
            s[i] ^= s[len - 1 - i];
        }
    }
}
