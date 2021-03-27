package com.MianShiQuestions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MiHoYo_03 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; ++i) {
            String input = br.readLine();
            Stack<Character> stack = new Stack<>();
            Stack<Integer> leftStack = new Stack<Integer>();
            Queue<Integer> rightQueue = new LinkedList<Integer>();
            boolean leftFlag = false;
            int root = 0;
            int num = 0;
            for (char ch : input.toCharArray()) {
                if (ch >= '0' && ch <= '9') {
                    num = num *10 + Integer.parseInt(String.valueOf(ch));
                } else if (ch == '(' && stack.isEmpty()) {
                    root = num;
                    num = 0;
                    stack.push(ch);
                    leftFlag = true;
                } else if (ch == '(' && stack.peek() == '(' && leftFlag) {
                    leftStack.push(num);
                } else if (ch == ',' && stack.peek() == '(' && leftFlag) {
                    leftStack.push(num);
                }
            }
        }
    }
}
