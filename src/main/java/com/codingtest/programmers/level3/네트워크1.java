package com.codingtest.programmers.level3;

//Link : https://school.programmers.co.kr/learn/courses/30/lessons/43162
public class 네트워크1 {
    List<Integer>[] graph;
    boolean[] visited;
    int n;
    int answer = 0;
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        graph = new ArrayList[n];
        this.n = n;

        for(int i =0; i<n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(i == j)continue;
                if(computers[i][j] == 1)graph[i].add(j);
            }
        }

        for(int i =0; i<n; i++){
            if(!visited[i]) {
                dfs(i);
                answer++;
            }
        }

        return answer;

    }

    private void dfs(int node){
        for(int next : graph[node]){
            if(!visited[next]){
                visited[next] = true;
                dfs(next);
            }
        }
    }
}
