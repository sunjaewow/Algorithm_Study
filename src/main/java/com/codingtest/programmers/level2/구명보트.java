package com.codingtest.programmers.level2;

import java.util.Arrays;

public class 구명보트 {
    public int solution(int[] people, int limit) {
        int count = 0;
        int right = people.length-1;
        int left = 0;
        Arrays.sort(people);

        while(left <= right){
            if(people[left] + people[right] <= limit){
                left++;
            }
            right--;
            count++;
        }
        return count;
    }
}
