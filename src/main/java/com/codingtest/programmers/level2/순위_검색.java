package com.codingtest.programmers.level2;

//Link : https://school.programmers.co.kr/learn/courses/30/lessons/72412
public class 순위_검색 {
    Map<String, List<Integer>> map = new HashMap<>();
    public int[] solution(String[] info, String[] query) {

        List<Integer> answer = new ArrayList<>();
        for(String i : info){
            String[] words = i.split(" ");
            dfs(words, "", 0);
        }

        for(List<Integer> list : map.values()){
            list.sort(Integer::compareTo);
        }

        for(String q : query){
            q = q.replace(" and ", " ");
            String[] words = q.split(" ");
            String key = words[0] + words[1] + words[2] + words[3];
            int score = Integer.parseInt(words[4]);
            if(!map.containsKey(key)) {
                answer.add(0);
                continue;
            }
            List<Integer> value = map.get(key);
            int start = 0;
            int end = value.size();
            while(start < end){
                int mid = (start + end)/2;

                if(value.get(mid) >= score) end = mid;
                else start = mid +1;
            }
            answer.add(value.size() - start);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private void dfs(String[] words, String current, int depth){
        if(depth == 4){
            int score = Integer.parseInt(words[depth]);
            map.computeIfAbsent(current, k-> new ArrayList<>())
                    .add(score);
            return ;
        }

        dfs(words, current + words[depth], depth+1);
        dfs(words, current + "-", depth+1);
    }
}
