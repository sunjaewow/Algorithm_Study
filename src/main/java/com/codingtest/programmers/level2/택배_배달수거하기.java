package com.codingtest.programmers.level2;

//Link : https://school.programmers.co.kr/learn/courses/30/lessons/150369
public class 택배_배달수거하기 {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        int deliveriesCount = 0;
        int pickupsCount = 0;
        long answer = 0;

        for(int i = n-1; i>=0; i--){
            deliveriesCount += deliveries[i];
            pickupsCount += pickups[i];

            while(deliveriesCount > 0 || pickupsCount > 0){
                answer += (long)(i+1)*2;
                deliveriesCount -= cap;
                pickupsCount -= cap;
            }
        }
        return answer;
    }
}
