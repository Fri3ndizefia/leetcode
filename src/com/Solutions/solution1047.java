package com.Solutions;

import java.util.Stack;

public class solution1047 {
    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<Character>();
        for (Character c : S.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
                continue;
            }
            stack.push(c);
        }
        StringBuffer result = new StringBuffer("");
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.reverse().toString();
    }

    public String removeDuplicates1(String S) {
        StringBuffer stack = new StringBuffer();
        int top = -1;
        for (int i = 0; i < S.length(); ++i) {
            char ch = S.charAt(i);
            if (top >= 0 && stack.charAt(top) == ch) {
                stack.deleteCharAt(top);
                --top;
            }else {
                stack.append(ch);
                ++top;
            }
        }
        return stack.toString();
    }
}