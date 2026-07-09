package com.codingtest.programmers.level3;

//Link : https://school.programmers.co.kr/learn/courses/30/lessons/67259
public class 경주로_건설 {
    public int solution(int[][] board) {
        int n = board.length;
        int[] dx = new int[]{1,-1,0,0};
        int[] dy = new int[]{0,0,1,-1};

        int[][][] cost = new int[n][n][4];

        for(int y=0;y<n;y++){
            for(int x=0;x<n;x++){
                Arrays.fill(cost[y][x], Integer.MAX_VALUE);
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0,-1,0});

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int x = current[1];
            int y = current[0];
            int dir = current[2];
            int currentCost = current[3];

            for(int i =0; i<4;i ++){
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if(nextX <0 || nextX >= n || nextY <0 || nextY >=n) continue;

                if(board[nextY][nextX] == 1) continue;

                int nextCost = currentCost;

                if(dir == -1 || dir == i) nextCost += 100;
                else nextCost += 600;

                if(cost[nextY][nextX][i] > nextCost){
                    cost[nextY][nextX][i] = nextCost;
                    queue.offer(new int[]{nextY, nextX, i, nextCost});
                }
            }

        }
        int answer = Integer.MAX_VALUE;

        for(int i =0; i<4; i++){
            answer = Math.min(answer, cost[n-1][n-1][i]);
        }

        return answer;
    }
}
