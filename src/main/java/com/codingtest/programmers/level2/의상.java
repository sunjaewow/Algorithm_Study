package com.codingtest.programmers.level2;

import java.util.HashMap;
import java.util.Map;

public class 의상 {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        int count = 1;

        for(String[] cloth : clothes){
            map.put(cloth[1], map.getOrDefault(cloth[1], 0) +1);
        }

        for(int value : map.values()){
            count *= value +1;
        }

        return count -1;
    }
}
