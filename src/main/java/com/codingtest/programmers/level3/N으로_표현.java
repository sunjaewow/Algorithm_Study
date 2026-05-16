package com.codingtest.programmers.level3;

import java.util.*;

public class N으로_표현 {
    public int solution(int N, int number) {
        Set<Integer>[] dp = new HashSet[9];

        int sum = 0;

        for(int i =1;i <9; i++){
            dp[i] = new HashSet<>();
            int s = sum*10 + N;
            dp[i].add(s);
            sum = s;
        }

        for(int count =1; count<9; count++){

            for(int leftCount = 1; leftCount < count; leftCount++){
                int rightCount = count - leftCount;

                for(int left : dp[leftCount]){
                    for(int right : dp[rightCount]){
                        dp[count].add(left + right);
                        dp[count].add(left - right);
                        dp[count].add(left * right);

                        if(right != 0) dp[count].add(left / right);
                    }
                }
            }

            if(dp[count].contains(number))return count;
        }
        return -1;

    }
}
