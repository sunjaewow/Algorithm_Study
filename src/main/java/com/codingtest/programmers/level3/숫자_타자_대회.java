package com.codingtest.programmers.level3;

//Link : https://school.programmers.co.kr/learn/courses/30/lessons/136797
public class 숫자_타자_대회 {
    import java.util.*;

    class Solution {
        int[][] position ={
                {3,1},
                {0,0},
                {0,1},
                {0,2},
                {1,0},
                {1,1},
                {1,2},
                {2,0},
                {2,1},
                {2,2},
        };
        public int solution(String numbers) {
            int[][] dp = new int[10][10];

            for(int i =0; i<10; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);

            dp[4][6] = 0;

            for(int i=0; i<numbers.length(); i++){
                int target = (int)(numbers.charAt(i) - '0');

                int[][] nextDp = new int[10][10];

                for(int j = 0; j<10; j++) Arrays.fill(nextDp[j], Integer.MAX_VALUE);

                for(int left = 0; left<10; left++){
                    for(int right=0; right<10; right++){

                        if(dp[left][right] == Integer.MAX_VALUE) continue;

                        int curCost = dp[left][right];

                        if(left == target || right == target){
                            nextDp[left][right] = Math.min(nextDp[left][right], curCost + 1);
                            continue;
                        }

                        nextDp[target][right] =
                                Math.min(nextDp[target][right], curCost + getCost(left, target));

                        nextDp[left][target] =
                                Math.min(nextDp[left][target], curCost + getCost(right, target));
                    }
                }

                dp = nextDp;
            }

            int answer = Integer.MAX_VALUE;

            for(int i =0; i<10; i++){
                for(int j = 0; j<10; j++){
                    answer = Math.min(answer, dp[i][j]);
                }
            }

            return answer;
        }

        private int getCost(int cur, int target){
            int[] curArray = position[cur];
            int[] targetArray = position[target];

            int rowDist = Math.abs(curArray[1] - targetArray[1]);
            int colDist = Math.abs(curArray[0] - targetArray[0]);

            int cross = Math.min(rowDist, colDist);
            int straigth = Math.abs(rowDist - colDist);

            return cross*3 + straigth *2;
        }
    }
}
