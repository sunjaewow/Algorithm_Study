package com.codingtest.leetcode.medium;

// Link : https://leetcode.com/problems/insert-into-a-binary-search-tree/
public class Insert_Into_BST {
    int val;
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        this.val = val;
        dfs(root);

        return root;
    }

    public void dfs(TreeNode node){
        if(node.val < val){
            if(node.right != null) dfs(node.right);
            else{
                node.right = new TreeNode(val);
                return ;
            }
        }else{
            if(node.left != null) dfs(node.left);
            else{
                node.left = new TreeNode(val);
                return ;
            }
        }

    }
}
