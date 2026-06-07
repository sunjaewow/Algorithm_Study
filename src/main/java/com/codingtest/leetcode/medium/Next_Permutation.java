package com.codingtest.leetcode.medium;

// Link : https://leetcode.com/problems/next-permutation/
public class Next_Permutation {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n-2;

        while(i >= 0 && nums[i+1] <= nums[i]) i--;

        if(i >= 0){
            int j = n-1;

            while(j >= 0 && nums[j] <= nums[i]) j--;

            swap(nums, i, j);

        }

        while(i+1 < n-1){
            swap(nums, i+1, n-1);
            i++;
            n--;
        }


    }

    public void swap(int[] nums, int idx1, int idx2){
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }
}
