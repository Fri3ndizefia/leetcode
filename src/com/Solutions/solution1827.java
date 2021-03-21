package com.Solutions;

import java.util.Stack;

public class solution1827 {

    private Stack<Integer> headStack;
    private Stack<Integer> tailStack;

    public solution1827(){
        headStack = new Stack<>();
        tailStack = new Stack<>();
    }

    public void appendTail(int value){
        while (!tailStack.isEmpty()) {
            headStack.push(tailStack.pop());
        }
        headStack.push(value);
    }

    public int deleteHead() {
        while (!headStack.isEmpty()) {
            tailStack.push(headStack.pop());
        }
        return tailStack.isEmpty() ? 0 : tailStack.pop();
    }
}
