package com.codingtest.level1;

public class 최소직사각형 {
    public int solution(int[][] sizes) {

        int max = 0;
        int min = 0;

        for(int[] size : sizes){
            int currentMax = Math.max(size[0], size[1]);
            int currentMin = Math.min(size[0], size[1]);

            max = Math.max(max, currentMax);
            min = Math.max(min, currentMin);
        }

        return max * min;
    }
}
