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
//Link : https://leetcode.com/problems/binary-tree-inorder-traversal/description/
public class Binary_Tree_Inorder_Traversal {
    List<Integer> list =new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        inOrder(root);

        return list;
    }

    public void inOrder(TreeNode node){
        if(node == null) return;

        inOrder(node.left);
        list.add(node.val);
        inOrder(node.right);
    }
}
