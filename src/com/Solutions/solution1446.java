package com.Solutions;

import java.util.Stack;

/**
 * 最长重复子字符串长度
 *
 */

public class solution1446 {
    public int maxPower(String s) {
        Stack<Character> stack = new Stack<>();
        int max = 0;
        int cnt = 1;
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() != c) {
                stack.push(c);
                cnt = 1;
            } else if (stack.peek() == c) {
                stack.push(c);
                ++cnt;
                max = Math.max(cnt, max);
            }
        }
        return max;
    }

    public int maxPower2(String s) {
        int left = 0;
        int right = 1;
        int max = 1;
        while (right < s.length()) {
            if (s.charAt(right) != s.charAt(left)) {
                max = Math.max(right - left, max);
                left = right;
            }
            ++right;
        }
        // right可能在最后的情况越界了，需要再次检验计算
        return Math.max(right - left, max);
    }
}
