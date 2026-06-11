package com.codingtest.leetcode.easy;

// Link : https://leetcode.com/problems/symmetric-tree/
public class Symmetric_Tree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)return true;
        return compare(root.left, root.right);
    }

    public boolean compare(TreeNode left, TreeNode right){
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;
        if(left.val != right.val) return false;
        return compare(left.left, right.right) && compare(left.right, right.left);
    }
}
