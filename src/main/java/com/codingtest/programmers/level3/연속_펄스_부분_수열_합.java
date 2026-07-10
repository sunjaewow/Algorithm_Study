package com.codingtest.programmers.level3;

//Link : https://school.programmers.co.kr/learn/courses/30/lessons/161988
public class 연속_펄스_부분_수열_합 {
    public long solution(int[] sequence) {
        long plus = sequence[0];
        long minus = -sequence[0];
        long answer = Math.max(plus, minus);

        for(int i = 1; i< sequence.length; i++){
            long prevPlus = plus;
            long prevMinus = minus;

            plus = Math.max(sequence[i], prevMinus + sequence[i]);

            minus = Math.max(-sequence[i], prevPlus - sequence[i]);

            answer = Math.max(answer, (Math.max(plus, minus)));
        }

        return answer;
    }
}
