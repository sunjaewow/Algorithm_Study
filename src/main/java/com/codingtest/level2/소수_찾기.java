package com.codingtest.level2;

import java.util.HashSet;
import java.util.Set;

public class 소수_찾기 {
    Set<Integer> set;
    boolean[] visited;
    public int solution(String numbers) {
        visited = new boolean[numbers.length()];
        set = new HashSet<>();

        dfs(numbers, "");

        int count = 0;

        for(int num : set){
            if(num < 2) continue;

            boolean isPrime = true;

            for(int i =2; i*i<=num; i++){
                if(num % i == 0) {
                    isPrime = false;
                    break;
                }
            }

            if(isPrime) count++;
        }

        return count;
    }

    public void dfs(String numbers, String current){
        if(!current.isEmpty()) set.add(Integer.parseInt(current));

        for(int i = 0; i<numbers.length(); i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(numbers, current + numbers.charAt(i));
                visited[i] = false;
            }
        }
    }
}
