package com.codingtest.programmers.level2;

//Link : https://school.programmers.co.kr/learn/courses/30/lessons/12978
public class 배달 {
    import java.util.*;

    class Solution {
        List<int[]>[] graph;
        int[] nodeArr;
        public int solution(int N, int[][] road, int K) {
            graph = new ArrayList[N+1];
            nodeArr = new int[N+1];

            Arrays.fill(nodeArr, Integer.MAX_VALUE);
            for(int i=1; i<=N; i++) graph[i] = new ArrayList<>();

            for(int[] r : road){
                int start = r[0];
                int end = r[1];
                int cost = r[2];

                graph[start].add(new int[]{end, cost});
                graph[end].add(new int[]{start, cost});
            }

            dfs(1, 0);
            int answer =0;
            for(int i =1; i<=N; i++){
                if(nodeArr[i] <= K) answer++;
            }

            return answer;
        }

        private void dfs(int node, int cost){
            nodeArr[node] = Math.min(nodeArr[node], cost);

            for(int[] next : graph[node]){
                if(nodeArr[next[0]] > cost + next[1]){
                    dfs(next[0], cost + next[1]);
                }
            }
        }
    }
}
