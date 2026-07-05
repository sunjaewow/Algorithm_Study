package com.codingtest.programmers.level3;

//Link : https://school.programmers.co.kr/learn/courses/30/lessons/12979
public class 기지국_설치 {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        int start = 1;

        for(int station : stations){
            int left = station - w;
            int right = station + w;

            if(start < left){
                answer += (((left - start) + w*2) / (w*2+1));
            }

            start = right + 1;
        }

        if(start <= n){
            answer += (((n - start+1) + w*2) / (w*2+1));
        }


        return answer;
    }
}
