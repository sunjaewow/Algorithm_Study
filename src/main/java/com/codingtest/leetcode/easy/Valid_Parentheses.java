package com.codingtest.leetcode.easy;

//Link : https://leetcode.com/problems/valid-parentheses/description/
public class Valid_Parentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch == '(' || ch =='{' || ch =='[') stack.push(ch);
            else if (ch == ')'){
                if(stack.size()==0 || stack.pop() != '(')return false;
            }else if (ch == '}'){
                if(stack.size()==0 || stack.pop() != '{')return false;
            }else if (ch == ']'){
                if(stack.size()==0 || stack.pop() != '[')return false;
            }else return false;
        }
        return stack.size() == 0;
    }
}
