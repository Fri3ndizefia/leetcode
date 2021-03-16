package com.Solutions;

import java.util.Stack;

public class solution1598 {
    public int minOperations(String[] logs) {

        Stack<String> stack = new Stack<String>();

        for (String s : logs) {
            if (s.equals("../") & stack.size() > 0) {
                stack.pop();
            }
            if (!s.equals("./") & !s.equals("../")) {
                stack.push(s);
            }
        }
        return stack.size();
    }
}
