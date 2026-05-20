package com.codingtest.leetcode.easy;

public class N_ary_Tree_Preorder_Traversal {
    List<Integer> list = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        preOrder(root);
        return list;
    }
    public void preOrder(Node root){
        if(root == null) return;
        list.add(root.val);

        for(Node node : root.children) preOrder(node);

    }
}
