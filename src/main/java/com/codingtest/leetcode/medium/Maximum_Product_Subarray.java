package com.codingtest.leetcode.medium;

//Link : https://leetcode.com/problems/maximum-product-subarray/description/
public class Maximum_Product_Subarray {
    public int maxProduct(int[] nums) {
        int[][] array = new int[nums.length][2];

        array[0][0] = nums[0];
        array[0][1] = nums[0];

        for(int i =1; i<nums.length; i++){
            int c = nums[i];
            array[i][0] = Math.max(c, Math.max(c * array[i-1][0], c* array[i-1][1]));
            array[i][1] = Math.min(c, Math.min(c * array[i-1][0], c* array[i-1][1]));
        }

        int max = nums[0];

        for(int i =0;i <nums.length; i++){
            if(array[i][0] > max) max = array[i][0];
        }
        return max;
    }
}
