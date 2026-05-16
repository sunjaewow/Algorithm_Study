package com.codingtest.programmers.level3;

public class 정수_삼각형 {
    public int solution(int[][] triangle) {
        int n = triangle.length;

        int[][] dp =new int [n][n];
        dp[0][0] = triangle[0][0];

        for(int y = 0; y<n-1; y++){
            for(int x =0; x<=y; x++){
                dp[y+1][x] = Math.max(dp[y][x] + triangle[y+1][x], dp[y+1][x]);
                dp[y+1][x+1] = Math.max(dp[y][x] + triangle[y+1][x+1], dp[y+1][x+1]);
            }
        }
        int max = 0;
        for(int num : dp[n-1]){
            if(num > max) max = num;
        }
        return max;
    }
}
