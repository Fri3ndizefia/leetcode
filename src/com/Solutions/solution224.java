package com.Solutions;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 基本计算器
 * 实现有 括号 ，加 ，减的基本计算器
 */
public class solution224 {

    /**
     * 字符串除了括号和数字以外，只有加号和减号的存在。
     * 展开所有的括号，数字不会变，只是数字前面的符号发生变化
     * 思路
     * 所有的减法运算改成 加上一个 负数 即可
     *
     *  进入一个括号之前，把在括号前出现的 sign 值放入栈
     *  这样 在进入括号进行运算的时候，调用 栈顶 peek 即可知道外面的sign 是正还是负
     *  比如说
     *  1 - （ 2 - 5 ）
     *  进入括号前，push进去 -1
     *  扫描 2： sign 是 stack.peek， 是 -1，也就是 1-2
     *  扫描 -： sign 是 peek的相反， 也就是 1，
     *  扫描 5： sign记录下来了 是 1， 也就是 1-2+5
     *
     *  意思就是将表达式的括号展开来写，
     * @param s
     * @return
     */
    public int calculate(String s) {
        Deque<Integer> ops = new LinkedList<>();
        ops.push(1);

        int sign = 1;
        int ret = 0;
        int n = s.length();
        int i = 0;
        while (i < n) {
            if (s.charAt(i) == ' ') {
                ++i;
            } else if (s.charAt(i) == '+') {
                sign = ops.peek();
                ++i;
            } else if (s.charAt(i) == '-') {
                sign = -ops.peek();
                ++i;
            } else if (s.charAt(i) == '(') {
                ops.push(sign);
                ++i;
            } else if (s.charAt(i) == ')') {
                ops.pop();
                ++i;
            } else {
                long num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    ++i;
                }
                ret += sign * num;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        solution224 s = new solution224();
        System.out.println(s.calculate("1-(2-3)-4"));
    }
}
