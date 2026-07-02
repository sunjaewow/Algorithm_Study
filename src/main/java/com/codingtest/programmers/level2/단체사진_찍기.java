package com.codingtest.programmers.level2;

//Link : https://school.programmers.co.kr/learn/courses/30/lessons/1835
public class 단체사진_찍기 {
    String[] words = {"A", "C", "F", "J", "M", "N", "R", "T"};
    boolean[] visited = new boolean[8];
    String[] data;
    int answer = 0;
    public int solution(int n, String[] data) {
        this.data = data;
        dfs(0, "");

        return answer;
    }

    private void dfs(int depth, String current){
        if(depth == 8){
            if(isRight(current)) answer++;
            return ;
        }

        for(int i =0; i<8; i++){
            if(!visited[i]){
                visited[i] = true;

                dfs(depth+1, current + words[i]);

                visited[i] = false;
            }
        }
    }

    private boolean isRight(String current){
        for(String d : data){


            char f1 = d.charAt(0);
            char f2 = d.charAt(2);
            char op = d.charAt(3);
            int num = d.charAt(4) - '0';

            int idx1 = 0;
            int idx2 = 0;

            for(int i =0; i<8; i++){
                if(current.charAt(i) == f1) idx1 = i;
                if(current.charAt(i) == f2) idx2 = i;
            }

            int diff = Math.abs(idx1 - idx2) - 1;

            if(op == '=' && diff != num) return false;
            if(op == '>' && diff <= num) return false;
            if(op == '<' && diff >= num) return false;

        }
        return true;
    }
}
