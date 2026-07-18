package com.codingtest.programmers.level3;

//Link : https://school.programmers.co.kr/learn/courses/30/lessons/42892
public class 길_찾기_게임 {
    List<Integer> preOrderList = new ArrayList<>();
    List<Integer> postOrderList = new ArrayList<>();

    public int[][] solution(int[][] nodeinfo) {
        int n = nodeinfo.length;
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) ->{
            if(a.y == b.y) return a.x - b.x;
            return b.y - a.y;
        });

        for(int i = 0; i<n; i++)
            pq.offer(new Node(i+1, nodeinfo[i][0], nodeinfo[i][1]));

        List<Node> candidates = new ArrayList<>();
        Node root = pq.poll();
        candidates.add(root);

        while(!pq.isEmpty()){
            Node firstChild = pq.poll();
            List<Node> childList = new ArrayList<>();
            childList.add(firstChild);
            while(!pq.isEmpty() && pq.peek().y == firstChild.y){
                childList.add(pq.poll());
            }


            for(int i =0; i<candidates.size(); i++){
                Node parent = candidates.get(i);

                for(int j = 0; j<childList.size(); j++){
                    Node child = childList.get(j);

                    if(parent.minX < child.x && parent.x > child.x ) {
                        parent.left = child;
                        child.minX = parent.minX;
                        child.maxX = parent.x;
                    }
                    else if(parent.x < child.x && child.x < parent.maxX) {
                        parent.right = child;
                        child.minX = parent.x;
                        child.maxX = parent.maxX;
                    }
                }

            }
            candidates = childList;
        }
        preOrder(root);
        postOrder(root);

        List<int[]> answer = new ArrayList<>();

        answer.add(preOrderList.stream().mapToInt(Integer::intValue).toArray());
        answer.add(postOrderList.stream().mapToInt(Integer::intValue).toArray());

        return answer.toArray(new int[answer.size()][]);
    }

    private void preOrder(Node node){
        if(node == null) return ;

        preOrderList.add(node.number);

        preOrder(node.left);
        preOrder(node.right);
    }

    private void postOrder(Node node){
        if(node == null) return ;

        postOrder(node.left);
        postOrder(node.right);

        postOrderList.add(node.number);
    }

    static class Node{
        int number;
        int x;
        int y;
        int minX = Integer.MIN_VALUE;
        int maxX = Integer.MAX_VALUE;

        Node left;
        Node right;
        public Node(int number, int x, int y){
            this.number = number;
            this.x = x;
            this.y = y;
        }
    }
}
