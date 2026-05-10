package com.codingtest.level3;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class 섬_연결하기 {
    public int solution(int n, int[][] costs) {
        List<int[]>[] graph = new ArrayList[n];
        boolean[] visited =  new boolean[n];

        for(int i =0; i<n; i++) graph[i] = new ArrayList<>();

        for(int[] node : costs){
            int startNode = node[0];
            int endNode = node[1];
            int cost = node[2];

            graph[startNode].add(new int[]{endNode, cost});
            graph[endNode].add(new int[]{startNode, cost});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)-> a[1] - b[1]);
        pq.offer(new int[]{0,0});

        int costSum = 0;
        int visitedCount = 0;

        while(!pq.isEmpty()){
            int[] current = pq.poll();
            int node = current[0];
            int cost = current[1];

            if(visited[node]) continue;
            visited[node] = true;
            visitedCount++;
            costSum += cost;

            if(visitedCount == n) break;

            for(int[] next : graph[node]){
                pq.offer(next);
            }
        }
        return costSum;
    }
}
