package com.codingtest.programmers.level1;

//Link : https://school.programmers.co.kr/learn/courses/30/lessons/468370
public class 중요한_단어를_스포_방지_kakao {
    public int solution(String message, int[][] spoiler_ranges) {
        int n = message.length();
        Set<String> normal = new HashSet<>();
        Set<String> spoiler = new HashSet<>();
        boolean[] spoilerRange = new boolean[n];

        for(int[] range : spoiler_ranges){
            int start = range[0];
            int end = range[1];
            for(int i = start; i<=end; i++) spoilerRange[i] = true;
        }

        int start = 0;
        while(start < n){
            int i = start;
            while(i < n && message.charAt(i) != ' ')i++;
            String word = message.substring(start, i);

            boolean isSpoiler = false;
            for(int j = start; j<i; j++){
                if(spoilerRange[j]){
                    isSpoiler = true;
                    break;
                }
            }

            if(isSpoiler) spoiler.add(word);
            else normal.add(word);

            start = i+1;
        }

        int answer =0;
        for(String word : spoiler){
            if(normal.contains(word))continue;
            else answer++;
        }
        return answer;
    }
}
public int solution(String message, int[][] spoiler_ranges) {
    Set<String> set = new HashSet<>();

    StringBuilder sb = new StringBuilder(message);

    for(int[] range : spoiler_ranges){
        for(int i = range[0]; i<= range[1]; i++){
            if(sb.charAt(i)== ' ') continue;
            sb.setCharAt(i, '|');
        }
    }

    for(String word : sb.toString().split(" ")){
        set.add(word);
    }

    int answer = 0;
    for(String word : message.split(" ")){
        if(!set.contains(word)){
            answer++;
            set.add(word);
        }
    }
    return answer;
}
