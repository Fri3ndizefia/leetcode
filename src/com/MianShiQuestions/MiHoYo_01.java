package com.MianShiQuestions;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class MiHoYo_01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();
        Stack<Character> stack = new Stack<>();
        int max = 0;
        for (char c : string.toCharArray()) {
            if (stack.isEmpty() && c == '1' || !stack.isEmpty() && stack.peek() == c) {
                stack.push(c);
            } else if (!stack.isEmpty() && c == '8' && stack.peek() == '1') {
                stack.push(c);
            } else if (!stack.isEmpty() && c == '0' && stack.peek() == '8') {
                stack.push(c);
            } else if (!stack.isEmpty() && c == '7' && stack.peek() == '0') {
                stack.push(c);
            } else if (!stack.isEmpty() && c == '8' && stack.peek() != '1') {
                while (true) {
                    if (!stack.isEmpty() && stack.peek() == '1' || !stack.isEmpty() && stack.peek() == '8') {
                        break;
                    }
                    stack.pop();
                }
                stack.push(c);
            } else if (!stack.isEmpty() && c == '0' && stack.peek() != '8') {
                while(true){
                    if (!stack.isEmpty() && stack.peek() == '8' || !stack.isEmpty() && stack.peek() == '0') {
                        break;
                    }
                    stack.pop();
                }
                stack.push(c);
            }
            max = Math.max(max, stack.size());
        }
        System.out.println(max);
    }

}
