package com.codingtest.leetcode.hard;

//Link : https://leetcode.com/problems/merge-k-sorted-lists/
public class Merge_k_Sorted_Lists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode listNode = null;
        Map<Integer, Integer> map =new HashMap<>();

        for(ListNode node : lists){
            while(true){
                if(node == null) break;
                map.put(node.val, map.getOrDefault(node.val, 0) + 1);
                node = node.next;
            }
        }


        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort((a,b)-> a-b);
        int firstVal = 0;

        if(list.size() == 0) return listNode;
        else {
            firstVal = list.get(0);
            listNode = new ListNode(firstVal); //첫 노드 저장 count 까야함
        }

        if(map.get(firstVal) == 1) {
            map.remove(firstVal);
            list.remove(0);
        }
        else map.put(firstVal, map.get(firstVal)-1);

        ListNode answer = listNode; //반환할 값

        for(int i = 0; i<list.size(); i++){
            int j = 0;
            int num = list.get(i);
            int count = map.get(num);

            while(j < count){
                ListNode current = new ListNode(num);
                listNode.next = current;
                listNode = listNode.next;
                j++;
            }
        }

        return answer;
    }
}
