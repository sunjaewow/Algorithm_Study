package com.codingtest.level1;

import java.util.HashMap;
import java.util.Map;

public class 완주하지_못한_선수 {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();

        for(String p : participant){
            map.put(p, map.getOrDefault(p, 0) + 1);
        }

        for(String c : completion){
            if(map.get(c) == 1) map.remove(c);
            else map.put(c, map.get(c) -1);
        }

        return map.keySet().iterator().next();

    }
}
