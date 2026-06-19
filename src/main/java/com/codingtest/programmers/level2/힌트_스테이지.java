package com.codingtest.programmers.level2;

//Link : https://school.programmers.co.kr/learn/courses/30/lessons/468377
public class 힌트_스테이지 {
    int[][] cost;
    int[][] hint;
    int len;
    int answer = Integer.MAX_VALUE;
    public int solution(int[][] cost, int[][] hint) {
        this.cost = cost;
        this.hint = hint;
        len = hint.length;

        dfs(0, new int[len]);

        return answer;
    }

    private void dfs(int depth, int[] stage){
        if(depth == len){
            int sum = 0;
            int[] arr = new int[cost.length+1];
            for(int i =0; i<len; i++){
                if(stage[i] == 0){
                    continue;
                }else{
                    sum += hint[i][0];
                    for(int j = 1; j<hint[i].length; j++){
                        arr[hint[i][j]]++;

                    }
                }
            }
            for(int i = 0; i<cost.length; i++){
                sum += cost[i][Math.min(arr[i+1], cost.length -1)];
            }

            answer = Math.min(answer, sum);
            return ;
        }
        stage[depth] = 0;
        dfs(depth +1, stage);

        stage[depth] = 1;
        dfs(depth +1, stage);
    }
}
