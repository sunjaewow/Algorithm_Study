package com.codingtest.programmers.level3;

//Link : https://school.programmers.co.kr/learn/courses/30/lessons/92343
public class 양과_늑대 {
    List<Integer>[] graph;
    int[] info;
    int answer = 0;
    public int solution(int[] info, int[][] edges) {
        int n = info.length;
        this.info = info;
        graph = new ArrayList[n];

        for(int i =0; i<n; i++) graph[i] = new ArrayList<>();

        for(int[] edge : edges)graph[edge[0]].add(edge[1]);

        List<Integer> candidates = new ArrayList<>();
        candidates.add(0);
        dfs(0, 0, candidates);

        return answer;
    }

    private void dfs(int sheepCount, int wolfCount, List<Integer> candidates){

        for(int candidate : candidates){
            int nextSheepCount = sheepCount;
            int nextWolfCount = wolfCount;
            if(info[candidate] == 0) nextSheepCount++;
            else nextWolfCount++;

            if(nextSheepCount <= nextWolfCount) continue;

            answer = Math.max(answer, nextSheepCount);

            List<Integer> newCandidates = new ArrayList<>(candidates);

            newCandidates.remove(Integer.valueOf(candidate));

            newCandidates.addAll(graph[candidate]);

            dfs(nextSheepCount, nextWolfCount, newCandidates);

        }

    }
}
