package com.Solutions;

import java.util.Stack;

/**
 * 括号最深处探寻
 */
public class solution1614 {
    /**
     * 这里可以不用 stack
     * 单纯的遍历字符就可以了
     * 用stack可以用多括号匹配的题目
     * @param s
     * @return
     */
    public int maxDepth(String s){
        Stack<Character> stack = new Stack<Character>();
        int depth = 0;
        int maxDepth = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
                ++depth;
            } else if (c == ')') {
                stack.pop();
                --depth;
            }
            maxDepth = Math.max(maxDepth, depth);
        }
        return maxDepth;
    }

}
