package com.codingtest.level2;

public class 피로도 {
    boolean[] visited;
    int[][] dungeons;
    int answer = 0;
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        this.dungeons = dungeons;

        dfs(k, 0);

        return answer;
    }

    public void dfs(int k, int count){
        answer = Math.max(count, answer);

        for(int i=0; i<dungeons.length; i++){
            if(visited[i] || k - dungeons[i][0] < 0) continue;
            visited[i] =true;
            dfs(k - dungeons[i][1], count + 1);
            visited[i] = false;
        }
    }
}
