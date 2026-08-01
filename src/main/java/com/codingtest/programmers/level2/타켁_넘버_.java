package com.codingtest.programmers.level2;

//Link : https://school.programmers.co.kr/learn/courses/30/lessons/43165
public class 타켁_넘버_ {
    class Solution {
        int[] numbers;
        int answer = 0;
        int n;
        int target;
        public int solution(int[] numbers, int target) {
            this.numbers = numbers;
            this.target = target;
            n = numbers.length;

            dfs(0, 0);

            return answer;
        }

        private void dfs(int sum, int depth){
            if(depth == n){
                if(sum == target) answer++;
                return ;
            }

            dfs(sum + numbers[depth], depth + 1);

            dfs(sum - numbers[depth], depth + 1);
        }
    }
}
