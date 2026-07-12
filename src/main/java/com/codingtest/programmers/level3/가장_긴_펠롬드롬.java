package com.codingtest.programmers.level3;

//Link : https://school.programmers.co.kr/learn/courses/30/lessons/12904
public class 가장_긴_펠롬드롬 {
    String s;
    public int solution(String s)
    {
        this.s = s;
        int answer = 0;
        for(int i =0; i<s.length(); i++){
            answer = Math.max(answer, expand(i, i));

            answer = Math.max(answer, expand(i, i+1));
        }

        return answer;
    }

    private int expand(int left, int right){

        while(left >=0 &&right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }

        return right - left - 1;
    }
}
