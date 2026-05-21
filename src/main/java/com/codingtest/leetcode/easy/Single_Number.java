package com.codingtest.leetcode.easy;

//Link : https://leetcode.com/problems/single-number/description/
public class Single_Number {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(int key : map.keySet()){
            if(map.get(key)== 1)return key;
        }
        return -1;
    }
}
//비트 연산 버전 있지만 이해가 안됨 나중에 ㄱㄱ
