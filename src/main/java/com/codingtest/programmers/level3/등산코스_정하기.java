package com.codingtest.programmers.level3;

//Link : https://school.programmers.co.kr/learn/courses/30/lessons/118669
public class 등산코스_정하기 {
    import java.util.*;

    class Solution {
        public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
            List<int[]>[] graph = new ArrayList[n+1];

            for(int i=1; i<=n; i++) graph[i] = new ArrayList<>();

            for(int[] path : paths){
                int start = path[0];
                int end = path[1];
                int cost = path[2];

                graph[start].add(new int[]{end, cost});
                graph[end].add(new int[]{start, cost});
            }

            boolean[] isGate = new boolean[n+1];
            boolean[] isSummit = new boolean[n+1];

            int[] intensity = new int[n+1];
            Arrays.fill(intensity, Integer.MAX_VALUE);

            PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[1] - b[1]);

            for(int gate : gates){
                isGate[gate] = true;
                intensity[gate] = 0;
                pq.offer(new int[]{gate, 0});
            }
            for(int summit : summits) isSummit[summit] = true;

            while(!pq.isEmpty()){
                int[] current = pq.poll();
                int currentNode = current[0];
                int currentIntensity = current[1];

                if(isSummit[currentNode]) continue;

                for(int[] nextInfo : graph[currentNode]){
                    int nextNode = nextInfo[0];
                    int nextCost = nextInfo[1];

                    if(isGate[nextNode]) continue;

                    int nextIntensity =  Math.max(currentIntensity, nextCost);

                    if(intensity[nextNode] > nextIntensity){
                        intensity[nextNode] = nextIntensity;
                        pq.offer(new int[]{nextNode, nextIntensity});

                    }

                }
            }

            int node = Integer.MAX_VALUE;
            int minIntensity = Integer.MAX_VALUE;

            for (int summit : summits) {
                if (intensity[summit] < minIntensity) {
                    minIntensity = intensity[summit];
                    node = summit;
                } else if (
                        intensity[summit] == minIntensity &&
                                summit < node
                ) {
                    node = summit;
                }
            }

            return new int[]{node, minIntensity};



        }
    }
}
