package com.codingtest.level2;

import java.util.PriorityQueue;

public class 가장_큰_수 {
    public String solution(int[] numbers) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) ->{
            return Integer.parseInt(String.valueOf(b) + String.valueOf(a)) -
                    Integer.parseInt(String.valueOf(a) + String.valueOf(b));
        });
        StringBuilder sb = new StringBuilder();
        for(int num : numbers) pq.offer(num);
        while(!pq.isEmpty()){
            sb.append(pq.poll());
        }
        if(sb.charAt(0)=='0')return "0";
        return sb.toString();

    }
}
