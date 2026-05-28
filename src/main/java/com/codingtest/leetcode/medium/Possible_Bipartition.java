package com.codingtest.leetcode.medium;

//Link : https://leetcode.com/problems/possible-bipartition/description/
public class Possible_Bipartition {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<Integer>[] graph = new ArrayList[n+1];

        for(int i =1 ;i<=n; i++) graph[i] = new ArrayList<>();

        for (int[] dislike : dislikes) {
            int a = dislike[0];
            int b = dislike[1];

            graph[a].add(b);
            graph[b].add(a);
        }

        int[] color = new int[n+1];

        for(int i=1; i<=n; i++){
            if(color[i] != 0) continue;

            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            color[i] = 1;

            while(!queue.isEmpty()){
                int current = queue.poll();

                for(int next : graph[current]){
                    if(color[next] == 0) {
                        color[next] = -color[current];
                        queue.offer(next);
                    }
                    else if(color[next] == color[current]) return false;
                }

            }
        }
        return true;
    }
}
