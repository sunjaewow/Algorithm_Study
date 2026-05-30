package com.codingtest.leetcode.medium;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
//Link : https://leetcode.com/problems/range-sum-of-bst/description/
public class Range_Sum_of_BST {
    int sum;
    int low;
    int high;
    public int rangeSumBST(TreeNode root, int low, int high) {
        this.low = low;
        this.high = high;

        dfs(root);

        return sum;
    }

    public void dfs(TreeNode node){
        if(node == null) return ;
        int value = node.val;
        if(value >= low && value <= high) sum+=value;

        dfs(node.left);
        dfs(node.right);

    }

}
