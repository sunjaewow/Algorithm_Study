package com.codingtest.programmers.level4;

//Link : https://school.programmers.co.kr/learn/courses/30/lessons/12983
public class 단어_퍼즐 {
    public int solution(String[] strs, String t) {
        int n = t.length();
        int[] dp = new int[n+1];

        Arrays.fill(dp, n+1);

        dp[0]= 0;

        for(int i =0; i<=n; i++){
            if(dp[i] == n+1) continue;

            for(String s : strs){
                int nextLocation = i + s.length();

                if(nextLocation > n) continue;

                if(t.startsWith(s, i)){
                    dp[nextLocation] = Math.min(dp[nextLocation], dp[i] + 1);
                }
            }
        }

        return dp[n] == n+1 ? -1 : dp[n];
    }
}
