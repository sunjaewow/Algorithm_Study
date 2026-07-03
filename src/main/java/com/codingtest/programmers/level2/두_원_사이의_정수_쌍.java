package com.codingtest.programmers.level2;

//Link : https://school.programmers.co.kr/learn/courses/30/lessons/181187
public class 두_원_사이의_정수_쌍 {
    public long solution(int r1, int r2) {
        long answer = 0;
        for(int x = 1; x<=r2; x++){
            long outer = (long)Math.floor(Math.sqrt((long)r2*r2 - (long)x*x));

            long inner;
            if(x >= r1) inner = 0;
            else inner = (long)Math.ceil(Math.sqrt((long)r1*r1 - (long)x*x));

            answer +=outer - inner + 1;
        }
        return answer*4;
    }
}
