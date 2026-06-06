package com.codingtest.leetcode.easy;

//Link : https://leetcode.com/problems/majority-element/
//과반수 알고리즘
public class Majority_Element {
    public int majorityElement(int[] nums) {
        int n = 0;
        int cnt = 0;

        for(int num : nums){
            if(cnt == 0){
                n = num;
                cnt++;
            }else if(n == num) cnt++;
            else{
                cnt--;
            }
        }
        return n;
    }
}
