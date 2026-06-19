package com.codingtest.programmers.level2;

//Link : https://school.programmers.co.kr/learn/courses/30/lessons/1829
public class 카카오프렌즈_컬러링북 {
    public int[] solution(int m, int n, int[][] picture) {
        boolean[][] visited = new boolean[m][n];
        int maxSize = -1;
        int count = 0;

        int[] dx = new int[]{0,0,-1,1};
        int[] dy = new int[]{-1,1,0,0};

        for(int i =0; i<m; i++){
            for(int j =0; j<n; j++){
                if(visited[i][j] || picture[i][j] == 0) continue;

                Queue<int[]> queue = new LinkedList<>();
                queue.offer(new int[]{i,j});
                visited[i][j] = true;

                int size = 1;

                while(!queue.isEmpty()){
                    int[] current = queue.poll();
                    int x = current[1];
                    int y = current[0];

                    for(int k=0; k<4; k++){
                        int nextX = x + dx[k];
                        int nextY = y + dy[k];

                        if(nextX >=0 && nextX <n && nextY >=0 && nextY <m
                                &&!visited[nextY][nextX]
                                &&picture[i][j] == picture[nextY][nextX]){
                            visited[nextY][nextX] = true;
                            size++;
                            queue.offer(new int[]{nextY, nextX});
                        }
                    }
                }
                count++;
                maxSize = Math.max(maxSize, size);

            }
        }

        return new int[]{count, maxSize};

    }
}
