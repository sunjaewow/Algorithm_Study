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

//Link : https://leetcode.com/problems/binary-tree-level-order-traversal-ii/description/
public class Binary_Tree_Level_Order_Traversal_2 {
    Map<Integer, List<Integer>> map =new HashMap<>();
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();

        postOrder(root,1);

        for(int i =map.keySet().size(); i>0; i--){
            answer.add(map.get(i));
        }

        return answer;
    }

    public void postOrder(TreeNode node, int depth){
        if(node == null) return;

        postOrder(node.left, depth +1);
        postOrder(node.right, depth + 1);
        map.computeIfAbsent(depth, k-> new ArrayList<>()).add(node.val);

    }
}
