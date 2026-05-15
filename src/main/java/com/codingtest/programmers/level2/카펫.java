package com.codingtest.programmers.level2;

public class 카펫 {
    public int[] solution(int brown, int yellow) {
        int sum = (brown - 4)/2;

        for(int i = 1; i*i <= yellow; i++){
            if(yellow % i == 0){
                int j = yellow/i;
                if(i + j == sum){
                    return new int[]{j+2, i+2};
                }
            }
        }
        return new int[]{-1, -1};
    }
}
