package com.Solutions;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 基本计算器 2
 *
 * 实现一个 可以计算 加减乘除，但是没有括号优先度的计算器
 * 由于乘除的优先度是高于加减的，
 *
 * 加法保存正数
 * 减法则保存负数
 *
 * 具体来说，preSign记录每个数字之前的运算符，对于第一个数字，其之前的加算符视为加号
 * 每次遍历到数字末尾的时候，根据preSign来决定计算方式
 *  加号：入栈
 *  减号：相反数入栈
 *  乘除号：计算数字与栈顶元素，并将栈顶元素替换成计算结果
 *
 * 遍历结束后，栈中元素相加即可
 */

public class solution227 {
    public int calculate(String s) {
        Deque<Integer> stack = new LinkedList<>();
        char preSign = '+';
        int num = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == n - 1) {
                switch (preSign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                }
                preSign = s.charAt(i);
                num = 0;
            }
        }
//        int ans = 0;
//        while (!stack.isEmpty()) {
//            ans += stack.pop();
//        }
        return stack.stream().mapToInt(Integer -> Integer).sum();
        //return stack.stream().mapToInt(Integer::intValue).sum() 更加正规
    }

}
