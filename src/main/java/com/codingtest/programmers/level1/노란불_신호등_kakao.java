package com.codingtest.programmers.level1;

// Link : https://school.programmers.co.kr/learn/courses/30/lessons/468371
public class 노란불_신호등_kakao {
    public int solution(int[][] signals) {
        int n = signals.length;
        int[] green = new int[n];
        int[] yellow = new int[n];
        int[] cycle = new int[n];
        int limit = 1;

        for(int i =0; i<n; i++){
            green[i] = signals[i][0];
            yellow[i] = signals[i][1];
            cycle[i] = signals[i][0] + signals[i][1] + signals[i][2];
            limit = lcm(limit, cycle[i]);
        }

        for(int i = 0 ; i< limit; i++){
            boolean isRight = true;

            for(int j = 0; j<n; j++){
                int time = i % cycle[j];
                if(time <= green[j] || time > green[j] + yellow[j]){
                    isRight = false;
                    break;
                }
            }

            if(isRight) return i;
        }
        return -1;

    }

    public int gcd(int num1, int num2){
        while(num2 != 0){
            int temp = num1 % num2;
            num1 = num2;
            num2 = temp;
        }
        return num1;
    }

    public int lcm(int num1, int num2){
        return num1*num2 / gcd(num1, num2);
    }
}
