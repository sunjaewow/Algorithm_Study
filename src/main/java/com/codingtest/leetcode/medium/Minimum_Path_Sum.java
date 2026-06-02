package com.codingtest.leetcode.medium;

//Link : https://leetcode.com/problems/minimum-path-sum/description/
public class Minimum_Path_Sum {
    public int minPathSum(int[][] grid) {
        int xLen = grid[0].length;
        int yLen = grid.length;

        for(int i = 0; i<yLen; i++){
            for(int j = 0; j<xLen; j++){
                if(i == 0 && j==0) continue;
                if(i == 0){
                    grid[i][j] += grid[i][j-1];
                }else if(j == 0){
                    grid[i][j] += grid[i-1][j];
                }else {
                    grid[i][j] += Math.min(grid[i][j-1], grid[i-1][j]);
                }
            }
        }

        return grid[yLen-1][xLen-1];


    }
}
