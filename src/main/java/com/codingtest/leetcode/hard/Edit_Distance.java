package com.codingtest.leetcode.hard;

//Link : https://leetcode.com/problems/edit-distance/
public class Edit_Distance {
    public int minDistance(String word1, String word2) {
        int word1Len = word1.length();
        int word2Len = word2.length();

        int[][] dp = new int[word1Len+1][word2Len+1];

        for(int i =0; i<=word1Len; i++){
            dp[i][0] = i;
        }

        for(int i =0; i<=word2Len; i++){
            dp[0][i] = i;
        }

        for(int i =1; i<=word1Len; i++){
            for(int j =1; j<=word2Len; j++){
                char c1 = word1.charAt(i-1);
                char c2 = word2.charAt(j-1);

                if(c1 == c2) dp[i][j] = dp[i-1][j-1];
                else{
                    int delete = dp[i-1][j];
                    int insert = dp[i][j-1];
                    int replace = dp[i-1][j-1];

                    dp[i][j]= Math.min(delete , Math.min(insert, replace)) + 1;
                }
            }
        }

        return dp[word1Len][word2Len];
    }
}
