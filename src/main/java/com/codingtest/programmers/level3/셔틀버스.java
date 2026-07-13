package com.codingtest.programmers.level3;

//Link : https://school.programmers.co.kr/learn/courses/30/lessons/17678
public class 셔틀버스 {
    public String solution(int n, int t, int m, String[] timetable) {
        PriorityQueue<Integer> time = new PriorityQueue<>();

        for(String timeT : timetable){
            int hour = Integer.parseInt(timeT.substring(0,2));
            int minute = Integer.parseInt(timeT.substring(3,5));

            time.offer(hour*60 + minute);
        }

        int answer= 0;
        for(int i =0; i<n; i++){
            int busTime = 9*60 + i*t;
            int count = 0;
            int currentTime = 0;
            while(!time.isEmpty() && count < m && time.peek() <= busTime){
                int current = time.poll();
                currentTime = current;
                count++;
            }

            if(i == n-1){
                if(count < m){
                    answer = busTime;
                }else
                    answer = currentTime -1;
            }

        }

        int hour = answer/60;
        int minute = answer%60;

        return String.format("%02d:%02d", hour, minute );
    }
}
