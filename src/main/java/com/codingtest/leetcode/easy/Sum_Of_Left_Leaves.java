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
 */
//Link : https://leetcode.com/problems/sum-of-left-leaves/description/
public class Sum_Of_Left_Leaves {
    int sum=0;

    public int sumOfLeftLeaves(TreeNode root) {
        dfs(root, false);
        return sum;
    }
    public void dfs(TreeNode node, boolean isLeft){
        if(node == null) return ;

        if(node.left == null && node.right == null && isLeft) {
            sum += node.val;
            return ;
        }

        dfs(node.left, true);

        dfs(node.right, false);
    }
}
