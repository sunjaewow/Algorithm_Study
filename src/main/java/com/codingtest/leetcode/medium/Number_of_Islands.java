package com.codingtest.leetcode.medium;

//Link : https://leetcode.com/problems/number-of-islands/description/
public class Number_of_Islands {
    public int numIslands(char[][] grid) {
        int xLen = grid[0].length;
        int yLen = grid.length;
        int answer = 0;

        boolean[][] visited = new boolean[yLen][xLen];

        int[] dx = new int[]{0,0,-1,1};
        int[] dy = new int[]{-1,1, 0, 0};

        for(int i = 0; i<yLen; i++){
            for(int j = 0; j<xLen; j++){
                if(grid[i][j] == '0' || visited[i][j]) continue;
                else{
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i,j});
                    visited[i][j] = true;

                    while(!queue.isEmpty()){
                        int[] current = queue.poll();
                        int x = current[1];
                        int y = current[0];

                        for(int k = 0; k<4; k++){
                            int nextX = x + dx[k];
                            int nextY = y + dy[k];

                            if(nextX >=0 && nextX < xLen && nextY >=0 && nextY < yLen
                                    && grid[nextY][nextX] == '1' && !visited[nextY][nextX]){
                                visited[nextY][nextX] = true;
                                System.out.println("x :" + nextX + ", y : "+ nextY);
                                queue.offer(new int[]{nextY, nextX});
                            }
                        }
                    }

                }
                answer++;
            }
        }

        return answer;

    }
}
