package com.codingtest.programmers.level2;

//Link : https://school.programmers.co.kr/learn/courses/30/lessons/389480
public class 완전_범죄 {
    int[][] info;
    boolean[][][] visited;
    int answer = Integer.MAX_VALUE;
    int n;
    int m;
    public int solution(int[][] info, int n, int m) {
        this.n = n;
        this.m = m;
        this.info = info;
        visited = new boolean[info.length+1][n][m];
        dfs(0, 0, 0);

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    private void dfs(int depth, int aSum, int bSum){
        if(aSum >= n || bSum >=m) return ;

        if(aSum >= answer) return ;

        if (visited[depth][aSum][bSum]) return;
        visited[depth][aSum][bSum] = true;

        if(depth == info.length){
            answer = Math.min(answer, aSum);
            return ;
        }

        dfs(depth+1, aSum + info[depth][0], bSum);
        dfs(depth+1, aSum, bSum + info[depth][1]);
    }
}
