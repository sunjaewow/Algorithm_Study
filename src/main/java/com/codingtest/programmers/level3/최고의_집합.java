package com.codingtest.programmers.level3;

//Link : https://school.programmers.co.kr/learn/courses/30/lessons/12938
public class 최고의_집합 {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];

        int value = s/n;
        int num = s%n;

        if(value == 0) return new int[]{-1};

        Arrays.fill(answer, value);

        if(num == 0) return answer;
        else{
            for(int i =n-1; i>=0; i--){
                if(num == 0) break;
                answer[i] += 1;
                num--;
            }
            Arrays.sort(answer);
        }
        return answer;
    }
}
