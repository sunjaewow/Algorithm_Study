package com.codingtest.level2;

public class 모음_사전 {
    String[] words = new String[]{"A", "E", "I", "O", "U"};
    String word;
    int answer=0;
    int count = 0;
    public int solution(String word) {
        this.word= word;
        dfs("");

        return answer;
    }

    public void dfs(String current){
        if(current.equals(word)) {
            answer = count;
            return;
        }

        if(current.length() == 5) return ;

        for(String w : words){
            count++;
            dfs(current+w);
        }
    }
}
