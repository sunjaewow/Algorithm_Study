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

//Link : https://leetcode.com/problems/kth-smallest-element-in-a-bst/submissions/2031388840/
public class Kth_Smallest_Element_in_a_BST {
    List<Integer> list = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {

        inorder(root);

        return list.get(k-1);
    }

    public void inorder(TreeNode node){
        if(node == null) return ;

        if(node.left != null) inorder(node.left);
        list.add(node.val);
        if(node.right != null) inorder(node.right);
    }
}
