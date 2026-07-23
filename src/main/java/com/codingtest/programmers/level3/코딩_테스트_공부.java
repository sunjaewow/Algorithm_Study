package com.codingtest.programmers.level3;

//Link : https://school.programmers.co.kr/learn/courses/30/lessons/118668
public class 코딩_테스트_공부 {
    import java.util.*;

    class Solution {
        public int solution(int alp, int cop, int[][] problems) {
            int alpMax = 0;
            int copMax = 0;

            for(int[] problem : problems) {
                alpMax = Math.max(alpMax, problem[0]);
                copMax = Math.max(copMax, problem[1]);
            }
            alp = Math.min(alp, alpMax);
            cop = Math.min(cop, copMax);
            int[][] dp = new int[alpMax + 1][copMax + 1];
            for(int i = 0; i<=alpMax; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);
            dp[alp][cop] = 0;



            for(int currentAlp = alp; currentAlp<=alpMax; currentAlp++){
                for(int currentCop = cop; currentCop<=copMax; currentCop++){

                    int currentCost = dp[currentAlp][currentCop];

                    if(currentCost == Integer.MAX_VALUE) continue;

                    if(currentAlp < alpMax)
                        dp[currentAlp +1][currentCop]
                                = Math.min(dp[currentAlp +1][currentCop], currentCost + 1);

                    if(currentCop < copMax)
                        dp[currentAlp][currentCop +1]
                                = Math.min(dp[currentAlp][currentCop +1], currentCost + 1);

                    for(int[] problem : problems){
                        int alp_req = problem[0];
                        int cop_req = problem[1];
                        int alp_rwd = problem[2];
                        int cop_rwd = problem[3];
                        int cost = problem[4];

                        int nextAlp = Math.min(alpMax, currentAlp + alp_rwd);
                        int nextCop = Math.min(copMax, currentCop + cop_rwd);

                        if(currentAlp >= alp_req && currentCop >= cop_req){
                            dp[nextAlp][nextCop] = Math.min(dp[nextAlp][nextCop], currentCost + cost);
                        }
                    }
                }
            }

            return dp[alpMax][copMax];
        }
    }

//모든 문제를 풀수있는 수치에 도달하기 위한 최단시간임
//rwd합쳐 값이 cost랑 같다면 직접 1시간소모해서 원하는 능력치올리는게 남
//rwd값이 더 크다면 peek에 도달하기 위한 cost와 req 더한값을 비교해서 낮은걸 선택
//그러다가 맥스값과 동등해지거나 많아지면 curCost반환

//dp 써야할듯 기존 값에서 문제를 풀어 획득할수있는 점수를 넣고 리스트 돌면서 해당 점수에 도달하기위한 최소 비용을 갱신하면서 max까지 도달하면 될듯한데
}
