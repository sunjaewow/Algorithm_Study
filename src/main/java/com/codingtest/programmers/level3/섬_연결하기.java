package com.codingtest.programmers.level3;

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

    import java.util.*;

    class Solution {
        int[] parent;
        public int solution(int n, int[][] costs) {
            Arrays.sort(costs, (a,b) -> a[2] - b[2]);
            parent = new int[n];

            for(int i =0; i<n; i++) parent[i] = i;

            int totalCost = 0;
            int visitedNode = 0;

            for(int[] c : costs){
                int start = c[0];
                int end = c[1];
                int cost = c[2];

                if(union(start, end)){
                    totalCost += cost;
                    visitedNode++;
                }

                if(visitedNode == n-1) return totalCost;
            }

            return -1;

        }

        private int find(int node){
            if(parent[node] == node) return node;

            return find(parent[node]);
        }

        private boolean union(int node1, int node2){
            int root1 = find(node1);
            int root2 = find(node2);

            if(root1 == root2) return false;

            parent[root1] = root2;

            return true;
        }
    }
}
