package com.codingtest.level1;

import java.util.ArrayList;
import java.util.List;

public class 같은_숫자는_싫어 {
    public int[] solution(int []arr) {
        List<Integer> list = new ArrayList<>();

        for(int num : arr){
            if(list.isEmpty() || list.get(list.size()-1) != num) list.add(num);
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
