package com.Solutions;


import java.util.Stack;

/**
 * 有效的括号字符串
 * 检查括号是否有效
 */
public class solution678 {


    public boolean checkValidString(String s) {
        int n = s.length();
        Stack<Integer> leftStack = new Stack<>();
        Stack<Integer> starStack = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                leftStack.push(i);
                //这里存放了 左括号 的下标值
            } else if (s.charAt(i) == '*') {
                starStack.push(i);
            } else{
                if (!leftStack.isEmpty()) {
                    leftStack.pop();
                } else {
                    if (!starStack.isEmpty()) {
                        starStack.pop();
                    }else{
                        return false;
                    }
                }
            }
        }
        // 结束入栈，进入 星号 下标和 左括号 下标的对比。
        // 寻找不符合题意的情况，一经发现，直接 false
        if (starStack.size() < leftStack.size()) {
            return false;
        } else {
            while (!starStack.isEmpty() && !leftStack.isEmpty()) {
                if (starStack.peek() < leftStack.peek()) {
                    return false;
                }
                starStack.pop();
                leftStack.pop();
            }
        }
        return true;
    }


    /**
     * 错误的自己写的解法，没有注意到 星号 应该要在 '(' 的右边
     * @param s
     * @return
     */
    public boolean wrongSolution(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for (Character c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == '*') {
                if(!stack.isEmpty()) {
                    ++count;
                }
            } else if (c == ')') {
                if (stack.isEmpty() && count == 0) {
                    return false;
                } else if (!stack.isEmpty()) {
                    stack.pop();
                } else if (stack.isEmpty() && count > 0) {
                    --count;
                }
            }
        }
        if (!stack.isEmpty() && stack.size() > count) {
            return false;
        }
        return true;
    }
}


