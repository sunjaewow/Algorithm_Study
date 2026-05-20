package com.codingtest.leetcode.easy;

public class Middle_of_the_Linked_List {
    public ListNode middleNode(ListNode head) {
        if(head.next == null) return head;
        ListNode node = head;
        ListNode nextNode = node.next;

        while(true){
            node = node.next;
            if(nextNode.next ==null || nextNode.next.next == null) return node;
            nextNode = nextNode.next.next;
        }
    }
}
