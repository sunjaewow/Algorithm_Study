package com.codingtest.level2;

import  java.util.*;

public class 게임_맵_최단거리 {
    public int solution(int[][] maps) {
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0, 1});
        visited[0][0] = true;

        int[] dx = new int[]{0,0,-1,1};
        int[] dy = new int[]{-1,1, 0, 0};

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int currentX = current[1];
            int currentY = current[0];
            int count = current[2];

            if(currentX == maps[0].length-1 && currentY == maps.length-1) return count;

            for(int i =0; i<4; i++){
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                if(nextX >=0 && nextX < maps[0].length
                        && nextY >=0 && nextY < maps.length
                        && maps[nextY][nextX] ==1 && !visited[nextY][nextX]){
                    visited[nextY][nextX] = true;
                    queue.offer(new int[]{nextY, nextX, count+1});
                }
            }
        }
        return -1;
    }
}
