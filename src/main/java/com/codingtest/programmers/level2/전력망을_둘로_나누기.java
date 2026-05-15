package com.codingtest.programmers.level2;

import java.util.*;

public class 전력망을_둘로_나누기 {
    List<Integer>[] graph;
    boolean[] visited;
    int n;
    int answer = Integer.MAX_VALUE;
    public int solution(int n, int[][] wires) {
        this.n = n;
        graph = new ArrayList[n+1];
        visited = new boolean[n+1];

        for(int i =1; i<=n; i++) graph[i] = new ArrayList<>();

        for(int[] wire : wires){
            int start = wire[0];
            int end = wire[1];

            graph[start].add(end);
            graph[end].add(start);
        }

        dfs(1);

        return answer;
    }

    public int dfs(int startNode){
        int count = 1;
        for(int next : graph[startNode]){
            if(visited[next]) continue;
            visited[startNode] = true;
            int childCount = dfs(next);

            answer = Math.min(answer, Math.abs(n- childCount*2));

            count += childCount;
        }
        return count;
    }
}
