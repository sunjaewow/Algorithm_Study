package com.codingtest.level3;

import java.util.LinkedList;
import java.util.Queue;

public class 단어_변환 {
    public int solution(String begin, String target, String[] words) {
        Queue<Word> queue = new LinkedList<>();
        boolean[] visited = new boolean[words.length];
        queue.offer(new Word(begin, 0));

        while(!queue.isEmpty()){
            Word current = queue.poll();

            if(current.word.equals(target)) return current.count;

            for(int i = 0; i<words.length; i++){
                if(visited[i]) continue;

                int c = 0;

                for(int j = 0; j<target.length(); j++){
                    if(words[i].charAt(j) != current.word.charAt(j)) c++;
                }
                if(c ==1) {
                    visited[i] = true;
                    queue.offer(new Word(words[i], current.count+1));
                }
            }
        }
        return 0;
    }

    static class Word{
        String word;
        int count;

        public Word(String word, int count){
            this.word = word;
            this.count = count;
        }
    }
}
