package com.codingtest.level2;

import java.util.ArrayList;
import java.util.List;

public class 기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();

        int current = (100-progresses[0] + speeds[0] - 1)/speeds[0];
        int count = 1;

        for(int i= 1 ; i<speeds.length; i++){
            int required = (100-progresses[i] + speeds[i] - 1)/speeds[i];

            if(current >= required){
                count++;
            }else{
                answer.add(count);
                count = 1;
                current = required;
            }
        }
        answer.add(count);

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
