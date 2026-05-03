package com.codingtest.level1;

import java.util.Arrays;

public class 폰켓몬 {
    public int solution(int[] nums) {
        return Math.min(Arrays.stream(nums).distinct().toArray().length, nums.length/2);
    }
}
