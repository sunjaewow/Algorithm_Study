package com.codingtest.programmers.level2;

//Link : https://school.programmers.co.kr/learn/courses/30/lessons/468373
public class 바이러스_파이프 {
    List<int[]>[] graph;
    boolean[] visited;
    int k;
    int n;
    int answer = 0;
    public int solution(int n, int infection, int[][] edges, int k) {
        graph = new ArrayList[n+1];
        visited = new boolean[n+1];
        this.k = k;
        this.n = n;

        for(int i =1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] edge : edges){
            int startNode = edge[0];
            int endNode = edge[1];
            int type = edge[2];

            graph[startNode].add(new int[]{endNode, type});
            graph[endNode].add(new int[]{startNode, type});
        }
        boolean[] infected = new boolean[n+1];
        infected[infection] = true;
        dfs(0, infected);

        return answer;
    }

    private void dfs(int depth, boolean[] infected){
        answer = Math.max(answer, count(infected));

        if(depth == k)return ;

        for(int i =1; i<=3; i++){
            Queue<Integer> queue = new LinkedList<>();
            boolean[] next = spread(i, infected);
            dfs(depth +1, next);
        }

    }

    private boolean[] spread(int type, boolean[] infected){
        boolean[] next = infected.clone();

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i<=n; i++){
            if(infected[i]) queue.offer(i);
        }

        while(!queue.isEmpty()){
            int current = queue.poll();

            for(int[] edge : graph[current]){
                int nextNode = edge[0];
                if(edge[1] != type) continue;

                if(next[nextNode]) continue;

                queue.offer(nextNode);
                next[nextNode] = true;


            }
        }
        return next;
    }

    private int count(boolean[] infected){
        int count =0;
        for(int i =0; i<infected.length; i++){
            if(infected[i]) count++;
        }
        return count;
    }


}
