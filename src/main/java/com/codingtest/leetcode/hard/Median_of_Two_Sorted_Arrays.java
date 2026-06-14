package com.codingtest.leetcode.hard;

//Link : https://leetcode.com/problems/median-of-two-sorted-arrays/
public class Median_of_Two_Sorted_Arrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size = nums1.length + nums2.length;
        int[] arr = new int[size/2 + 1];
        int idx1 = 0;
        int idx2 = 0;

        for(int i =0; i<=size/2; i++){
            if(idx1 < nums1.length && (idx2 >= nums2.length || nums1[idx1] <= nums2[idx2])){
                arr[i] = nums1[idx1];
                idx1++;
            }else{
                arr[i] = nums2[idx2];
                idx2++;
            }
        }

        return size %2 == 0 ? (arr[arr.length -1] + arr[arr.length -2])/2.0 : arr[arr.length -1];

    }

}
