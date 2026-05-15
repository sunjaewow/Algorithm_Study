package com.codingtest.programmers.level3;

import java.util.*;

public class 네트워크 {
    List<Integer>[] graph;
    boolean[] visited;
    int visitedCount =0;
    public int solution(int n, int[][] computers) {
        graph = new ArrayList[n+1];
        visited = new boolean[n+1];

        for(int i = 1; i<=n; i++) graph[i] = new ArrayList<>();

        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(i == j)continue;
                if(computers[i][j] == 1){
                    int startNode = i+1;
                    int endNode = j+1;
                    graph[startNode].add(endNode);
                    graph[endNode].add(startNode);
                }
            }
        }

        int count =0;

        for(int i = 1 ; i<=n; i++){
            if(visited[i])continue;
            dfs(i);
            count++;
        }

        return count;
    }

    public void dfs(int startNode){
        visitedCount++;
        for(int next : graph[startNode]){
            if(visited[next]) continue;
            visited[next] = true;
            dfs(next);
        }
    }
}
