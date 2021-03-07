package com.Solutions;

import java.util.Stack;

/**
 * 格式化字符串 插入 '-'
 */
public class solution482 {
    public static String licenseKeyFormatting(String s, int K) {
        Stack<Character> list = new Stack<Character>();
        for (char c : s.toUpperCase().toCharArray()) {
            if (c != '-') {
                list.push(c);
            }
        }
        String result = new String();
        int counter = 0;
        while (!list.isEmpty()) {
            if(counter == K){
                counter = 0;
                result += '-';
            }
            result += list.pop();
            ++counter;
        }
        String result2 = new String();
        for (int i = result.length() - 1; i >= 0; --i) {
            result2 += result.charAt(i);
        }
        return result2;
    }

    public static void main(String[] args) {
        System.out.println(licenseKeyFormatting("5F3Z-2e-9-w", 4));

    }
}
