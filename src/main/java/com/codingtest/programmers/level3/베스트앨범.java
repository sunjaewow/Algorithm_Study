package com.codingtest.programmers.level3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class 베스트앨범 {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genreMap = new HashMap<>();
        Map<String, List<Song>> songMap = new HashMap<>();
        List<Integer> answer = new ArrayList<>();

        int n = genres.length;

        for(int i =0; i<n; i++){
            genreMap.put(genres[i], genreMap.getOrDefault(genres[i], 0) + plays[i]);
            songMap.computeIfAbsent(genres[i], k -> new ArrayList<>()).add(new Song(plays[i], i));
        }

        List<String> list = genreMap.keySet().stream().sorted((a,b)-> genreMap.get(b)- genreMap.get(a))
                .collect(Collectors.toList());
        for(String genre : list){
            List<Song> songList = songMap.get(genre);
            songList.sort((a,b) -> b.plays - a.plays);
            for(int i=0; i< Math.min(songList.size(), 2); i++){
                answer.add(songList.get(i).number);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();

    }

    static class Song{
        int plays;
        int number;

        public Song(int plays, int number){
            this.plays = plays;
            this.number = number;
        }
    }
}
