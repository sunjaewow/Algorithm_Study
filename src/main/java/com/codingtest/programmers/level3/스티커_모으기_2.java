package com.codingtest.programmers.level3;

//Link : https://school.programmers.co.kr/learn/courses/30/lessons/12971
public class 스티커_모으기_2 {
    int[] sticker;
    int n;
    public int solution(int sticker[]) {
        this.sticker = sticker;
        n = sticker.length;

        if(n == 1) return sticker[0];

        return Math.max(getMax(0, n-2), getMax(1, n-1));
    }

    private int getMax(int start, int end){
        if(start == end) return sticker[start];

        int[] dp = new int[n];
        dp[start] = sticker[start];
        dp[start + 1] = Math.max(sticker[start], sticker[start+1]);

        for(int i = start+2; i<= end; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + sticker[i]);
        }

        return dp[end];


    }
}
