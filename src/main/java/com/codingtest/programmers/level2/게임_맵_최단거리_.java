package com.codingtest.programmers.level2;

//Link : https://school.programmers.co.kr/learn/courses/30/lessons/1844
public class 게임_맵_최단거리_ {
    import java.util.*;

    class Solution {
        public int solution(int[][] maps) {
            int h = maps.length;
            int w = maps[0].length;
            int answer = Integer.MAX_VALUE;

            int[] dy = {-1, 1, 0, 0};
            int[] dx = {0, 0, -1, 1};

            boolean[][] visited = new boolean[h][w];
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{0, 0, 1});
            visited[0][0] = true;

            while(!queue.isEmpty()){
                int[] current = queue.poll();
                int y = current[0];
                int x = current[1];
                int cost = current[2];

                if(y == h - 1 && x == w -1) {
                    answer = cost;
                    break;

                }

                for(int i = 0; i<4; i++){
                    int nextX = x + dx[i];
                    int nextY = y + dy[i];

                    if(nextX >=0 && nextX < w && nextY>=0 && nextY <h && !visited[nextY][nextX]
                            && maps[nextY][nextX] ==1){
                        visited[nextY][nextX] = true;
                        queue.offer(new int[]{nextY, nextX, cost + 1});
                    }
                }

            }


            return answer == Integer.MAX_VALUE ? -1 : answer;
        }
    }
}
