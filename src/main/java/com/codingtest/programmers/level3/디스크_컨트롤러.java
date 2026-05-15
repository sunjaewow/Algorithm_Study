package com.codingtest.programmers.level3;

import java.util.*;

public class 디스크_컨트롤러 {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a,b) -> a[0] - b[0]);


        PriorityQueue<Disk> pq = new PriorityQueue<>((a,b)-> {
            if(a.workingTime == b.workingTime){
                if(a.requiredTime == b.requiredTime){
                    return a.number - b.number;
                }
                return a.requiredTime - b.requiredTime;
            }
            return a.workingTime - b.workingTime;
        });

        int time = 0;
        int idx = 0;
        int answer = 0;

        while(idx < jobs.length || !pq.isEmpty()){
            while(idx < jobs.length &&jobs[idx][0] <= time){
                pq.offer(new Disk(jobs[idx][0], jobs[idx][1], idx));
                idx++;
            }
            if(!pq.isEmpty()){
                Disk disk = pq.poll();
                time += disk.workingTime;
                answer += time - disk.requiredTime;
            }else time++;
        }

        return answer/jobs.length;
    }

    static class Disk{
        int requiredTime;
        int workingTime;
        int number;

        public Disk(int requiredTime, int workingTime, int number){
            this.requiredTime = requiredTime;
            this.workingTime = workingTime;
            this.number = number;
        }
    }
}
