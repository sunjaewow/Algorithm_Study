package com.codingtest.level2;

public class 타켓_넘버 {
    int[] numbers;
    int target;
    int answer = 0;
    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;

        dfs(0, 0);

        return answer;
    }

    public void dfs(int count, int sum){
        if(count== numbers.length){
            if(sum == target) answer++;
            return;
        }

        dfs(count+1, sum + numbers[count]);
        dfs(count+1, sum - numbers[count]);
    }
}
