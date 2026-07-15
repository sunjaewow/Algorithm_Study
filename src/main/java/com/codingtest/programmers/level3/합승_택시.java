package com.codingtest.programmers.level3;

//Link : https://school.programmers.co.kr/learn/courses/30/lessons/72413
public class 합승_택시 {
    List<int[]>[] graph;
    int n;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        graph = new ArrayList[n+1];
        this.n = n;
        for(int i =1; i<=n; i++) graph[i] = new ArrayList<>();

        for(int[] fare : fares){
            int start = fare[0];
            int end = fare[1];
            int cost = fare[2];

            graph[start].add(new int[]{end, cost});
            graph[end].add(new int[]{start, cost});
        }

        int[] sWay = dijkstra(s);
        int[] aWay = dijkstra(a);
        int[] bWay = dijkstra(b);

        int answer = Integer.MAX_VALUE;

        for(int i =1; i<=n; i++){
            int sum = sWay[i]+ aWay[i] + bWay[i];
            answer = Math.min(answer, sum);
        }

        return answer;
    }

    private int[] dijkstra(int node){
        int[] result = new int[n+1];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[node] = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(node, 0));

        while(!queue.isEmpty()){
            Node current = queue.poll();

            for(int[] next : graph[current.number]){
                int nextNode = next[0];
                int nextCost = next[1];
                int newCost = current.cost + nextCost;

                if(result[nextNode] > newCost){
                    result[nextNode] = newCost;
                    queue.offer(new Node(nextNode, newCost));
                }
            }
        }
        return result;
    }

    static class Node{
        int number;
        int cost;
        public Node(int number, int cost){
            this.number = number;
            this.cost = cost;
        }
    }
}
