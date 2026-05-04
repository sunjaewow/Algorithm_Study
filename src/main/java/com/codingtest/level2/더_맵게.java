package com.codingtest.level2;

import java.util.PriorityQueue;

public class 더_맵게 {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int s : scoville)pq.offer(s);

        int count = 0;

        while(pq.peek() < K){
            if(pq.size()<=1) return -1;
            pq.offer(pq.poll() + pq.poll()*2);
            count++;
        }
        return count;
    }
}
