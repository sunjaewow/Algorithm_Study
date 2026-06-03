package com.codingtest.leetcode.medium;

//Link : https://leetcode.com/problems/unique-paths-ii/
public class Unique_Path_2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int xLen = obstacleGrid[0].length;
        int yLen = obstacleGrid.length;
        if(obstacleGrid[0][0] == 1) return 0;

        int[][] dp = new int[yLen][xLen];
        dp[0][0] = 1;

        for(int i = 0 ; i<yLen; i++){
            for(int j = 0; j<xLen; j++){
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                    continue;
                }

                if(i ==0 && j ==0) continue;

                int top = 0;
                int left = 0;

                if(i > 0) top = dp[i-1][j];
                if(j > 0) left = dp[i][j-1];

                dp[i][j] = top + left;
            }
        }

        return dp[yLen-1][xLen-1];
    }
}
