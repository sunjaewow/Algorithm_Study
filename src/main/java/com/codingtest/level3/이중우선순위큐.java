package com.codingtest.level3;

import java.util.PriorityQueue;

public class 이중우선순위큐 {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>((a,b)-> b-a);

        for(String operation : operations){
            String[] arr = operation.split(" ");
            if(arr[0].equals("D")){
                if(arr[1].equals("1")){
                    min.remove(max.poll());
                }else{
                    max.remove(min.poll());
                }
            }else{
                min.offer(Integer.parseInt(arr[1]));
                max.offer(Integer.parseInt(arr[1]));
            }
        }

        return min.isEmpty() ? new int[]{0,0} : new int[]{max.peek(), min.peek()};
    }
}
