package com.codingtest.leetcode.medium;

// Link : https://leetcode.com/problems/binary-tree-right-side-view/description/
public class Binary_Tree_Right_Side_View {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        if(root == null) return answer;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i =0; i<size; i++){
                TreeNode current = queue.poll();
                if(i == size-1) answer.add(current.val);
                if(current.left!=null) queue.offer(current.left);
                if(current.right!=null) queue.offer(current.right);
            }
        }

        return answer;

    }
}
