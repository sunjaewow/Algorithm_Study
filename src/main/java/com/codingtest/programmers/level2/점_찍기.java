package com.codingtest.programmers.level2;

//Link : https://school.programmers.co.kr/learn/courses/30/lessons/140107
public class 점_찍기 {
    class Solution {
        public long solution(int k, int d) {
            long answer = 0;

            for(int i = 0; i<=d; i+=k){
                long distance = (long)Math.floor(Math.sqrt((long)d*d - (long)i*i));

                answer += distance/k + 1;
            }

            return answer;
        }
    }

}
