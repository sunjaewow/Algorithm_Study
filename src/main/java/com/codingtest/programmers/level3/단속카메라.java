package com.codingtest.programmers.level3;

import java.util.Arrays;

public class 단속카메라 {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (a, b)-> a[1] - b[1]);

        int camera = -30000;
        int count = 0;

        for(int[] route : routes){
            if(route[0] <= camera && route[1] >= camera) continue;
            else {
                camera = route[1];
                count++;
            }
        }

        return count;
    }
}
