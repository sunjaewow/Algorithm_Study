package com.codingtest.leetcode.medium;

// link :https://leetcode.com/problems/min-stack/description/
public class Min_Stack {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int value) {
        stack.push(value);
        if(minStack.isEmpty()){
            minStack.push(value);
        }else{
            if(value <= minStack.peek()) minStack.push(value);
        }

    }

    public void pop() {
        if(stack.peek().equals(minStack.peek())) minStack.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
