package com.codingtest.programmers.level3;

import java.util.ArrayList;
import java.util.List;

//Link : https://school.programmers.co.kr/learn/courses/30/lessons/1832
public class 보행자_천국 {
    int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        int[][][] dp = new int[m][n][2];
        dp[0][0][0] = 1;

        for(int i =0; i<m; i++){
            for(int j =0; j<n; j++){

                if(cityMap[i][j] == 1)continue;

                int horizontal = dp[i][j][0];
                int vertical = dp[i][j][1];

                if(cityMap[i][j] == 0){
                    int sum = dp[i][j][0] + dp[i][j][1];

                    if(j+1<n) dp[i][j+1][0] = (dp[i][j+1][0] + sum) % MOD;
                    if(i+1<m) dp[i+1][j][1] = (dp[i+1][j][1] + sum) % MOD;
                }else{
                    if(j+1<n) dp[i][j+1][0] = (dp[i][j+1][0] + horizontal) % MOD;
                    if(i+1<m) dp[i+1][j][1] = (dp[i+1][j][1] + vertical) % MOD;
                }
            }
        }

        return (dp[m-1][n-1][0] + dp[m-1][n-1][1]) % MOD;
    }
}
