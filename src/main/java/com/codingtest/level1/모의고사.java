package com.codingtest.level1;

import java.util.ArrayList;
import java.util.List;

public class 모의고사 {
    public int[] solution(int[] answers) {
        int[] first = new int[]{1,2,3,4,5};
        int[] second = new int[]{2,1,2,3,2,4,2,5};
        int[] third = new int[]{3,3,1,1,2,2,4,4,5,5,3,3};

        int firstCount = 0;
        int secondCount = 0;
        int thirdCount = 0;

        List<Integer> answer = new ArrayList<>();

        for(int i =0; i<answers.length; i++){
            if(answers[i] == first[i%5]) firstCount++;
            if(answers[i] == second[i%8]) secondCount++;
            if(answers[i] == third[i%10]) thirdCount++;
        }

        int max = Math.max(firstCount, Math.max(secondCount, thirdCount));

        if(max == firstCount) answer.add(1);
        if(max == secondCount) answer.add(2);
        if(max == thirdCount) answer.add(3);

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
