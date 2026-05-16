package com.codingtest.leetcode.easy;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 * Link : https://leetcode.com/problems/merge-two-sorted-lists/
 */
public class Merge_Two_Sorted_Lists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = null;
        ListNode current = null;

        while(list1 !=null || list2 != null){
            if(list2 == null || (list1 !=null && list1.val < list2.val)){
                if(head == null){
                    head = list1;
                    current = list1;
                    list1 = list1.next;
                }else{
                    current.next = list1;
                    current = list1;
                    list1 = list1.next;
                }
            }else{
                if(head == null){
                    head = list2;
                    current = list2;
                    list2 = list2.next;
                }else{
                    current.next = list2;
                    current = list2;
                    list2 = list2.next;
                }
            }
        }

        return head;
}
