package com.codingtest.leetcode.medium;

// Link : https://leetcode.com/problems/linked-list-cycle-ii/submissions/2028355466/
public class Linked_List_Cycle_2 {
    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;

        ListNode n1 = head;
        ListNode n2 = head;

        while(n2 != null && n2.next != null){
            n1 = n1.next;
            n2 = n2.next.next;

            if(n1 == n2){
                n1 = head;
                while(n1 != n2){
                    n1 = n1.next;
                    n2 = n2.next;
                }
                return n2;
            }
        }

        return null;
    }

}
