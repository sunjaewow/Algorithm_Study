package com.codingtest.level3;

import java.util.Arrays;

public class 입국심사 {
    public long solution(int n, int[] times) {
        Arrays.sort(times);

        long right =(long) n*times[0];
        long left = 1;
        long answer = 0;

        while(left<=right){
            long mid = (right + left)/2;
            long count = 0;

            for(int time : times){
                count += mid/time;
            }
            if(count < n) left = mid +1;
            else {
                answer = mid;
                right = mid-1;
            }

        }
        return answer;
    }
}
