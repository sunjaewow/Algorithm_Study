package com.codingtest.leetcode.medium;

//Link : https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
public class Binary_Tree_Zigzag_Level_Order_Traversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if(root==null) return answer;
        queue.offer(root);
        int deep = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i<size; i++){
                TreeNode current = queue.poll();
                list.add(current.val);
                if(current.left!=null)queue.offer(current.left);
                if(current.right!=null)queue.offer(current.right);

            }
            if(deep %2 != 0) Collections.reverse(list);
            answer.add(list);

            deep++;
        }
        return answer;
    }
}
