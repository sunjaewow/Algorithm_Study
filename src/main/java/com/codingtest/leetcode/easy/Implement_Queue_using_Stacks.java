package com.codingtest.leetcode.easy;

// Link : https://leetcode.com/problems/implement-queue-using-stacks/submissions/2027086526/
public class Implement_Queue_using_Stacks {
    Stack<Integer> in = new Stack<>();
    Stack<Integer> out = new Stack<>();

    public MyQueue() {

    }

    public void push(int x) {
        in.push(x);
    }

    public int pop() {
        peek();
        return out.pop();
    }

    public int peek() {
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return out.peek();
    }

    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
}
