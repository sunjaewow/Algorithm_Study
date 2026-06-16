package com.codingtest.programmers.level2;

//Link : https://school.programmers.co.kr/learn/courses/30/lessons/388353
public class 지계차와_크레인 {
    int[] dx = new int[]{0,0,-1,1};
    int[] dy = new int[]{-1,1,0,0};
    public int solution(String[] storage, String[] requests) {
        int n = storage[0].length();
        int m = storage.length;
        int answer = n*m;
        char[][] arr = new char[m+2][n+2];

        for(int i = 0; i<m+2; i++) Arrays.fill(arr[i], '.');

        for(int i =1; i<=m; i++){
            for(int j = 1; j<=n; j++){
                arr[i][j] = storage[i-1].charAt(j-1);
            }
        }

        for(String request : requests){
            char target = request.charAt(0);
            if(request.length() == 2){
                //포그레인
                for(int i =0; i<m+2; i++){
                    for(int j =0; j<n+2; j++){
                        if(arr[i][j] == target){
                            arr[i][j] = '.';
                            answer--;
                        }
                    }
                }
            }else{
                //지게차
                boolean[][] outLine = getOutLine(arr, m, n);
                List<int[]> removeList = new ArrayList<>();

                for(int i =1; i<m+1; i++){
                    for(int j =1; j<n+1; j++){
                        if(arr[i][j] != target) continue;

                        for(int k=0;k<4;k++){
                            int nextX = j + dx[k];
                            int nextY = i + dy[k];

                            if(outLine[nextY][nextX]){
                                removeList.add(new int[]{i, j});
                                break;
                            }
                        }
                    }
                }

                for(int[] remove : removeList){
                    arr[remove[0]][remove[1]] = '.';
                    answer--;
                }
            }
        }

        return answer;
    }

    public boolean[][] getOutLine(char[][] arr, int m , int n){
        boolean[][] visited = new boolean[m+2][n+2];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0});
        visited[0][0] = true;

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int x = current[1];
            int y = current[0];

            for(int i =0; i<4; i++){
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if(nextX >=0 && nextX <n+2 && nextY >=0 && nextY <m+2
                        && !visited[nextY][nextX] && arr[nextY][nextX] == '.'){
                    visited[nextY][nextX] = true;
                    queue.offer(new int[]{nextY, nextX});
                }
            }
        }
        return visited;
    }
}
