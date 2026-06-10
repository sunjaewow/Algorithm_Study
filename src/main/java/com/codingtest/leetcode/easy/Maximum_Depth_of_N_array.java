package com.codingtest.leetcode.easy;

//Link : https://leetcode.com/problems/maximum-depth-of-n-ary-tree/description/
public class Maximum_Depth_of_N_array {
    public int maxDepth(Node root) {
        if(root == null) return 0;

        int depth = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i =0; i<size; i++){
                Node current = queue.poll();
                for(Node next : current.children) queue.offer(next);
            }
            depth++;
        }

        return depth;
    }
}
