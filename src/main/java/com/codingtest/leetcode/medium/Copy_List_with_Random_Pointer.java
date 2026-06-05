package com.codingtest.leetcode.medium;

//Link : https://leetcode.com/problems/copy-list-with-random-pointer/description/
public class Copy_List_with_Random_Pointer {
    Map<Node, Node> map = new HashMap<>();
    public Node copyRandomList(Node head) {
        return inorder(head);
    }

    public Node inorder(Node node){
        if(node == null) return null;

        if(map.containsKey(node)) return map.get(node);

        Node copy = new Node(node.val);

        map.put(node, copy);

        copy.random = inorder(node.random);
        copy.next = inorder(node.next);

        return copy;

    }
}
