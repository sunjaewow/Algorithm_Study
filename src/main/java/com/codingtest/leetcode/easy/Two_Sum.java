package com.codingtest.leetcode.easy;

//Link : https://leetcode.com/problems/two-sum/description/
public class Two_Sum {
    Map<Integer, Integer> map = new HashMap<>();

        for(int i= 0; i<nums.length; i++){
        if(map.containsKey(nums[i])){
            return new int[]{map.get(nums[i]), i};
        }

        map.put(target-nums[i], i);
    }
        return new int[]{-1, -1};
}
