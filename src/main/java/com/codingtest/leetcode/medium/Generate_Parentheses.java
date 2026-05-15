package com.codingtest.leetcode.medium;

import java.util.*;

public class Generate_Parentheses {
    List<String> answer = new ArrayList<>();
    int n;
    public List<String> generateParenthesis(int n) {
        this.n = n;
        dfs(0,0,"");
        return answer;
    }

    public void dfs(int openCount, int closeCount, String current){
        if(openCount == n && closeCount == n){
            answer.add(current);
            return ;
        }
        if(openCount < n) dfs(openCount + 1, closeCount, current + "(");
        if(openCount > closeCount) dfs(openCount, closeCount+1, current+ ")");
    }
}
