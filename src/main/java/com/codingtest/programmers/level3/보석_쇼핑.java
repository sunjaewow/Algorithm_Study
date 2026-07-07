package com.codingtest.programmers.level3;

//Link : https://school.programmers.co.kr/learn/courses/30/lessons/67258
public class 보석_쇼핑 {
    public int[] solution(String[] gems) {
        int min = Integer.MAX_VALUE;
        int[] answer = new int[2];
        Map<String, Integer> map = new HashMap<>();
        Set<String> kind = new HashSet<>(List.of(gems));

        int left = 0;

        for(int i = 0; i<gems.length; i++){
            map.put(gems[i], map.getOrDefault(gems[i], 0) + 1);

            while(kind.size() == map.size()){
                int start = left;
                int end = i;

                if(min > end - start){
                    min = end - start;
                    answer = new int[]{start+1, end+1};
                }

                Integer count = map.get(gems[left]);
                if(count == 1){
                    map.remove(gems[left]);
                }else{
                    map.put(gems[left], count-1);
                }
                left++;

            }

        }

        return answer;

    }
}
