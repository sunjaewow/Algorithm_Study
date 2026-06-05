package com.codingtest.leetcode.medium;

//Link : https://leetcode.com/problems/validate-binary-search-tree/description/
public class Validate_Binary_Search_Tree {
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean dfs(TreeNode node, Long min, Long max){
        if(node == null) return true;

        if(node.val <= min || node.val >= max )return false;

        return dfs(node.left, min, Long.valueOf(node.val)) && dfs(node.right, Long.valueOf(node.val), max);
    }
}
