package com.codingtest.leetcode.medium;

//Link : https://leetcode.com/problems/unique-paths/description/
public class Unique_Paths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        for(int i = 0; i<m; i++){
            for(int j =0; j<n; j++){
                if(i == 0 && j == 0) continue;
                int top = 0;
                int left = 0;
                if(i>0) top = dp[i-1][j];
                if(j>0) left = dp[i][j-1];

                dp[i][j] = top + left;
            }
        }
        return dp[m-1][n-1];
    }
}
