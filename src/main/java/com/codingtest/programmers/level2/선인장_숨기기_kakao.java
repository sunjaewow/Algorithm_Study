package com.codingtest.programmers.level2;

// Link : https://school.programmers.co.kr/learn/courses/30/lessons/468379
//시간 더 줄여야함
public class 선인장_숨기기_kakao {
    public int[] solution(int m, int n, int h, int w, int[][] drops) {
        int[][] map = new int[m][n];
        Area min = new Area(0,0,0);

        for(int i =0; i<drops.length; i++)
            map[drops[i][0]][drops[i][1]] = i+1;

        for(int i = 0; i<=m-h; i++){
            for(int j = 0; j<=n-w; j++){

                boolean isPassed = true;
                int val = drops.length+1;
                boolean out = false;

                for(int k = i; k< i + h; k++){
                    for(int z = j; z< j+ w; z++){
                        if(map[k][z] > 0) {
                            val = Math.min(val, map[k][z]);
                            isPassed = false;
                            if(val < min.val) {
                                out =true;
                                break;
                            }
                        }
                    }
                    if(out) break;
                }
                if(out) continue;

                if(isPassed) return new int[]{i, j};
                else{
                    if(min.val >= val) continue;
                    else{
                        min = new Area(i, j, val);
                    }
                }

            }
        }

        return new int[]{min.m, min.n};
    }

    static class Area{
        int m;
        int n;
        int val;

        public Area(int m, int n, int val){
            this.m = m;
            this.n = n;
            this.val = val;
        }
    }
}
