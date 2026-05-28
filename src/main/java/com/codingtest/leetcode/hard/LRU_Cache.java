package com.codingtest.leetcode.hard;

// Link : https://leetcode.com/problems/lru-cache/description/
public class LRU_Cache {
    static class Node{
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    Node head;
    Node tail;
    Map<Integer,Node> map;
    int capacity;

    public LRUCache(int capacity) {
        head = null;
        tail = null;
        map = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        else{
            Node node = map.get(key);
            if(node != tail){
                if(node == head){
                    head = node.next;
                    head.prev =null;
                }else{
                    node.prev.next = node.next;
                    node.next.prev = node.prev;
                }
                node.next =null;
                tail.next = node;
                node.prev = tail;
                tail = node;
            }
            return node.value;
        }
    }

    public void put(int key, int value) {
        if(!map.containsKey(key)){
            Node node = new Node(key, value);
            map.put(key, node);
            if(head == null) {
                head = node;
                tail = node;
            }
            else if(tail == null) tail = node;
            else{
                tail.next = node;
                node.prev = tail;
                tail = node;
            }

            if(map.size() > capacity){
                map.remove(head.key);
                head = head.next;

                if(head == null){
                    tail = null;
                }else{
                    head.prev =null;
                }
            }
        }else{
            Node node = map.get(key);
            node.value = value;

            if(node != tail){
                if(node == head){
                    head = node.next;
                    head.prev = null;
                }else{
                    node.prev.next = node.next;
                    node.next.prev = node.prev;
                }
                node.next = null;
                tail.next = node;
                node.prev = tail;
                tail = node;
            }
        }
    }

}
