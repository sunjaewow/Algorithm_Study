package com.codingtest.programmers.level4;

//Link : https://school.programmers.co.kr/learn/courses/30/lessons/67260
public class 동굴_탐험 {
    import java.util.*;

    class Solution {
        public boolean solution(int n, int[][] path, int[][] order) {
            List<Integer>[] graph = new ArrayList[n];

            for(int i = 0; i<n; i++)graph[i] = new ArrayList<>();

            for(int[] p : path){
                int start = p[0];
                int end = p[1];

                graph[start].add(end);
                graph[end].add(start);
            }

            int[] beforeRoom = new int[n];
            int[] lockedRoom = new int[n];

            Arrays.fill(beforeRoom, -1);
            Arrays.fill(lockedRoom, -1);

            for(int[] o : order){
                int before = o[0];
                int after = o[1];

                beforeRoom[before] = after;
                lockedRoom[after] = before;
            }

            if(lockedRoom[0] != -1) return false;

            boolean[] waitingRoom = new boolean[n];

            Queue<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[n];
            visited[0] = true;
            queue.offer(0);

            int count = 1;
            while(!queue.isEmpty()){
                int current = queue.poll();

                int before = beforeRoom[current];

                if(before != -1 && waitingRoom[before]){
                    waitingRoom[before] = false;
                    queue.offer(before);
                    visited[before] = true;
                    count++;
                }

                for(int next : graph[current]){
                    if(visited[next]) continue;

                    int lock = lockedRoom[next];

                    if(lock != -1 && !visited[lock]){
                        waitingRoom[next] = true;
                        continue;
                    }
                    visited[next] = true;
                    queue.offer(next);
                    count++;
                }
            }
            return count == n;
        }
    }
}
