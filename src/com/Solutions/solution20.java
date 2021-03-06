package com.Solutions;


import java.util.*;

/**
 * 匹配括号题
 * 有效括号寻找
 *
 * 主要思路：栈
 */
public class solution20 {

    /**
     * 标准用 栈 法， 括号匹配推出栈顶
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        } else if (s.length() == 0) {
            return true;
        }

        Map<Character, Character> hash = new HashMap<Character, Character>();
        hash.put(')', '(');
        hash.put('}', '{');
        hash.put(']', '[');
        System.out.println(hash);
        Deque<Character> stack = new LinkedList<Character>();
        for (char c : s.toCharArray()) {
            if(stack.contains(c)){
                if (stack.isEmpty() || stack.peek() != hash.get(c)) {
                    return false;
                }else if(hash.containsKey(c)){
                    stack.pop();
                }
            }
            stack.push(c);
        }
        return true;
    }

    public static boolean isValidPlus(String s) {
        Deque<Character> stack = new LinkedList<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == '{') {
                stack.push(c);
            } else if (c == '[') {
                stack.push(c);
            }else if (!stack.isEmpty()) {
                if (c == ')' && stack.peek() == '(') {
                    stack.pop();
                } else if (c == ']' && stack.peek() == '[') {
                    stack.pop();
                } else if (c == '}' && stack.peek() == '{') {
                    stack.pop();
                } else {
                    return false;
                }
            } else{
                return false;
            }
        }
        if(stack.isEmpty()) {
            return true;
        }
        return false;
    }

    public static boolean isValidFromOthers(String s) {
        if(s.isEmpty())
            return true;
        Stack<Character> stack=new Stack<Character>();
        for(char c:s.toCharArray()){
            if(c=='(')
                stack.push(')');
            else if(c=='{')
                stack.push('}');
            else if(c=='[')
                stack.push(']');
            else if(stack.empty()||c!=stack.pop())
                return false;
        }
        if(stack.empty())
            return true;
        return false;
    }

    public static void main(String[] args) {
        String s = "({[]})";
        System.out.println(isValidPlus("]"));
    }
}
