package com.codingtest.level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 프로세스 {
    public int solution(int[] priorities, int location) {
        Queue<Process> queue = new LinkedList<>();

        for(int i =0; i<priorities.length; i++){
            queue.offer(new Process(priorities[i], i));
        }

        Arrays.sort(priorities);
        int idx =priorities.length-1;
        int currentRank = priorities[idx];

        int count = 0;

        while(!queue.isEmpty()){
            Process process = queue.poll();
            if(process.rank == currentRank){
                count++;

                if(process.location == location){
                    return count;
                }
                currentRank = priorities[--idx];
            }else queue.offer(process);
        }

        return -1;

    }

    static class Process{
        int rank;
        int location;

        public Process(int rank, int location){
            this.rank = rank;
            this.location = location;
        }
    }
}
