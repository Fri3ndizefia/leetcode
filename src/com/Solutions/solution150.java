package com.Solutions;

import java.util.Stack;

/**
 *
 * 逆波兰表示法
 *
 * 栈 的思路
 */
public class solution150 {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<String>();
        int number1 = 0;
        int number2 = 0;
        int res = 0;
        for (String s : tokens) {
            if (s.equals("+")) {
                number1 = Integer.parseInt(stack.pop());
                number2 = Integer.parseInt(stack.pop());
                res = number1 + number2;
                stack.push(Integer.toString(res));
            } else if (s.equals("-")) {
                number1 = Integer.parseInt(stack.pop());
                number2 = Integer.parseInt(stack.pop());
                res = number2 - number1;
                stack.push(Integer.toString(res));
            } else if(s.equals("*")){
                number1 = Integer.parseInt(stack.pop());
                number2 = Integer.parseInt(stack.pop());
                res = number2 * number1;
                stack.push(Integer.toString(res));
            } else if (s.equals("/")) {
                number1 = Integer.parseInt(stack.pop());
                number2 = Integer.parseInt(stack.pop());
                res = number2 / number1;
                stack.push(Integer.toString(res));
            } else {
                stack.push(s);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
