package com.codingtest.programmers.level2;

//Link : https://school.programmers.co.kr/learn/courses/30/lessons/181188
public class 요격_시스템 {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (a,b) -> {
            if(a[1] == b[1]) return a[0] - b[0];
            return a[1] - b[1];
        });

        int answer = 0;
        double weapon = -1;

        for(int[] target : targets){
            int start = target[0];
            int end = target[1];

            if(start < weapon && weapon < end) continue;
            else {
                weapon = end - 0.5;
                answer++;
            }
        }

        return answer;
    }
}
