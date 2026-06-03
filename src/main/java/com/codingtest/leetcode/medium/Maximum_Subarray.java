package com.codingtest.leetcode.medium;

//Link : https://leetcode.com/problems/maximum-subarray/
public class Maximum_Subarray {
    public int maxSubArray(int[] nums) {
        int max =nums[0];
        int sum =nums[0];

        for(int i =1; i<nums.length; i++){
            if(sum+nums[i] < nums[i]){
                sum = nums[i];
                max = Math.max(max, nums[i]);
            }else{
                sum += nums[i];
                max = Math.max(sum , max);
            }

        }
        return max;
    }
}
