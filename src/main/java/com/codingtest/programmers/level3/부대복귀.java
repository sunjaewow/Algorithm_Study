package com.codingtest.programmers.level3;

//Link : https://school.programmers.co.kr/learn/courses/30/lessons/132266
public class 부대복귀 {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        List<Integer>[] graph = new ArrayList[n+1];
        int[] answer = new int[sources.length];
        int idx = 0;

        for(int i = 1; i<=n; i++) graph[i] = new ArrayList<>();

        for(int[] road : roads){
            int start = road[0];
            int end = road[1];
            graph[start].add(end);
            graph[end].add(start);
        }

        for(int source : sources){
            boolean[] visited = new boolean[n+1];
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{source, 0});
            visited[source] = true;
            boolean isRight = false;

            while(!queue.isEmpty()){
                int[] current = queue.poll();
                int node = current[0];
                int cost = current[1];

                if(node == destination) {
                    answer[idx++] = cost;
                    isRight = true;
                    break;
                }

                for(int next : graph[node]){
                    if(visited[next]) continue;
                    visited[next] = true;
                    queue.offer(new int[]{next, cost+1});
                }
            }
            if(!isRight) answer[idx++] = -1;
        }

        return answer;
    }
}
