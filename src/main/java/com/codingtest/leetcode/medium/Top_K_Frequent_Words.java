package com.codingtest.leetcode.medium;

// Link : https://leetcode.com/problems/top-k-frequent-words/description/
public class Top_K_Frequent_Words {
    public List<String> topKFrequent(String[] words, int k) {
        PriorityQueue<Word> pq = new PriorityQueue<>((a,b)-> {
            if(a.count == b.count) return a.word.compareTo(b.word);
            return b.count-a.count;
        });

        List<String> answer = new ArrayList<>();

        Map<String,Integer> map =new HashMap<>();

        for(String word : words){
            map.put(word, map.getOrDefault(word, 0)+1);
        }

        for(String word : map.keySet()){
            pq.offer(new Word(word, map.get(word)));
        }
        for(int i =0;i<k;i++) answer.add(pq.poll().word);

        return answer;
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
