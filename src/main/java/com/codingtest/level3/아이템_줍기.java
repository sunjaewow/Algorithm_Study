package com.codingtest.level3;

import java.util.*;

public class 아이템_줍기 {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        boolean[][] outLine =new boolean[102][102];
        boolean[][] inLine = new boolean[102][102];
        boolean[][] visited= new boolean[102][102];

        for(int[] r : rectangle){
            int x1 = r[0]*2;
            int y1 = r[1]*2;

            int x2 = r[2]*2;
            int y2 = r[3]*2;

            for(int i = x1; i<=x2; i++){
                outLine[y1][i] = true;
                outLine[y2][i]= true;

                if(i == x1 || i == x2) continue;
                inLine[y1+1][i]= true;
                inLine[y2-1][i]= true;
            }

            for(int i = y1; i<=y2; i++){
                outLine[i][x1]= true;
                outLine[i][x2]= true;

                if(i == y1 || i == y2) continue;
                inLine[i][x1+1]= true;
                inLine[i][x2-1]= true;
            }
        }


        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{characterY*2, characterX*2, 0});
        visited[characterY*2][characterX*2] = true;

        int[] dx = new int[]{0,0,-1,1};
        int[] dy = new int[]{-1,1, 0, 0};

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int x = current[1];
            int y = current[0];
            int count = current[2];

            if(x == itemX*2 && y == itemY*2) return count/2;

            for(int i =0; i<4; i++){
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if(nextX >=0 && nextX<102 && nextY >=0 && nextY<102
                        && outLine[nextY][nextX] && !inLine[nextY][nextX]
                        && !visited[nextY][nextX]){
                    visited[nextY][nextX] = true;
                    queue.offer(new int[]{nextY,nextX, count+1});
                }
            }
        }
        return -1;
    }
}
