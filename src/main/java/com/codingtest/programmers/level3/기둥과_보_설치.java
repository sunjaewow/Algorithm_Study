package com.codingtest.programmers.level3;

//Link : https://school.programmers.co.kr/learn/courses/30/lessons/60061
public class 기둥과_보_설치 {
    boolean[][][] map;
    int n;
    public int[][] solution(int n, int[][] build_frame) {
        map = new boolean[n+1][n+1][2];
        this.n = n;

        for(int[] f : build_frame){
            int x = f[0];
            int y = f[1];
            int type = f[2];
            int isCreated = f[3];

            if(isCreated == 1){
                map[y][x][type] = true;

                if(!isPossible()) map[y][x][type] = false;
            }else{
                map[y][x][type] = false;
                if(!isPossible()) map[y][x][type] = true;
            }
        }

        List<int[]> answer = new ArrayList<>();

        for(int i = 0; i<=n; i++){
            for(int j = 0; j<=n; j++){
                if(map[j][i][0]) answer.add(new int[]{i,j,0});
                if(map[j][i][1]) answer.add(new int[]{i,j,1});
            }
        }

        return answer.toArray(new int[answer.size()][]);
    }

    private boolean isPossible(){
        for(int i =0; i<=n; i++){
            for(int j=0; j<=n; j++){
                if(map[i][j][0] && !isPossibleBuilding(i, j)) return false;
                if(map[i][j][1] && !isPossibleStraight(i, j)) return false;
            }
        }
        return true;
    }

    private boolean isPossibleBuilding(int y, int x){
        if(y==0) return true;

        if(map[y-1][x][0]) return true;

        if(x>0 && map[y][x-1][1]) return true;

        if(map[y][x][1]) return true;

        return false;
    }

    private boolean isPossibleStraight(int y, int x){
        if(y>0 && map[y-1][x][0]) return true;

        if(x<n && y>0 && map[y-1][x+1][0]) return true;

        if(x>0 && x<n && map[y][x-1][1] && map[y][x+1][1]) return true;

        return false;
    }
}
