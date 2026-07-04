package com.codingtest.programmers.level3;
//Link : https://school.programmers.co.kr/learn/courses/30/lessons/12927
public class 야근_지수 {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        long answer = 0;

        for(int work : works) pq.offer(work);

        for(int i=0; i<n; i++){
            int work = pq.poll();
            if(work == 0) return 0;
            work--;
            pq.offer(work);
        }

        while(!pq.isEmpty()){
            int current = pq.poll();
            answer += Math.pow(current, 2);
        }

        return answer;
    }
}
