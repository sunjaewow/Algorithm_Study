package com.codingtest.leetcode.medium;

// Link : https://leetcode.com/problems/binary-search-tree-iterator/
public class Binary_Search_Tree_Iterator {
    TreeNode node;
    List<Integer> list = new ArrayList<>();
    int count = 0;
    public BSTIterator(TreeNode root) {
        node = root;
        dfs(node);
    }

    public int next() {
        return list.get(count++);
    }

    public boolean hasNext() {
        if(list.size() <= count) return false;
        return true;
    }

    public void dfs(TreeNode node){
        if(node == null) return ;

        if(node.left != null) dfs(node.left);
        list.add(node.val);
        if(node.right != null) dfs(node.right);
    }
}
