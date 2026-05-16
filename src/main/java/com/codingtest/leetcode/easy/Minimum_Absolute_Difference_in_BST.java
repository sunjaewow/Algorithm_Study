package com.codingtest.leetcode.easy;
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
 * Link : https://leetcode.com/problems/minimum-absolute-difference-in-bst/
 */
public class Minimum_Absolute_Difference_in_BST {
    int prev = -1;
    int answer = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return answer;
    }

    public void inorder(TreeNode node){
        if(node == null) return;

        inorder(node.left);
        if(prev != -1){
            answer = Math.min(answer, node.val - prev);
        }
        prev = node.val;

        inorder(node.right);
    }
}
