package com.codingtest.programmers.level3;

//Link : https://school.programmers.co.kr/learn/courses/30/lessons/72414
public class 광고_삽입 {
    class Solution {
        public String solution(String play_time, String adv_time, String[] logs) {
            int playTime = getSecond(play_time);
            int advTime = getSecond(adv_time);

            int[] humanCount = new int[playTime+1];

            for(String log : logs){
                String[] ranges = log.split("-");

                int start = getSecond(ranges[0]);
                int end = getSecond(ranges[1]);

                humanCount[start]++;
                humanCount[end]--;
            }

            for(int i =1;i <= playTime; i++){
                humanCount[i] += humanCount[i-1];
            }

            long[] humanSumCount = new long[playTime +1];

            for(int i =0; i<playTime; i++){
                humanSumCount[i+1] += humanSumCount[i] + humanCount[i];
            }

            long maxCost = humanSumCount[advTime];
            int answer = 0;

            for(int start = 1; start + advTime<= playTime; start++){
                int end = start + advTime;

                long cost = humanSumCount[end] - humanSumCount[start];

                if(maxCost < cost){
                    maxCost = cost;
                    answer = start;
                }
            }

            return String.format("%02d:%02d:%02d", answer/3600, (answer % 3600)/60, answer%60);

        }

        private int getSecond(String log){
            String[] times = log.split(":");
            int hour = Integer.parseInt(times[0]);
            int minute = Integer.parseInt(times[1]);
            int second = Integer.parseInt(times[2]);

            return hour * 3600 + minute * 60 + second;
        }
    }
}
