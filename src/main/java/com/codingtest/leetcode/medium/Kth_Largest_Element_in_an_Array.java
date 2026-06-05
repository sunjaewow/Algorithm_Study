package com.codingtest.leetcode.medium;

//Link : https://leetcode.com/problems/kth-largest-element-in-an-array/description/
public class Kth_Largest_Element_in_an_Array {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> b-a);
        int answer =0;

        for(int num : nums) pq.offer(num);

        int i = 0;
        while(i < k){
            answer = pq.poll();
            i++;
        }
        return answer;
    }
}
