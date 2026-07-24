package com.codingtest.programmers.level3;

//Link : https://school.programmers.co.kr/learn/courses/30/lessons/150365
public class 미로_탈출_명령ㅇ {
    import java.util.*;

    class Solution {
        public String solution(int n, int m, int x, int y, int r, int c, int k) {
            int[] dx = {1, 0, 0, -1};
            int[] dy = {0, -1, 1, 0};

            char[] dir = {'d', 'l', 'r', 'u'};

            int dist = Math.abs(x-r) + Math.abs(y - c);

            if(dist > k || (k-dist) %2 == 1) return "impossible";

            StringBuilder sb = new StringBuilder();

            int curX = x;
            int curY = y;

            for(int i =0; i<k; i++){

                int remain = k-i-1;
                for(int j =0; j<4; j++){
                    int nextX = curX + dx[j];
                    int nextY = curY + dy[j];

                    if(nextX >=1 && nextX <=n && nextY >=1 && nextY <=m){
                        int nextDist = Math.abs(nextX - r) + Math.abs(nextY - c);

                        if(nextDist > remain || (remain - nextDist) %2 == 1) continue;
                        curX = nextX;
                        curY = nextY;
                        sb.append(dir[j]);
                        break;
                    }
                }

            }

            return sb.toString();
        }


    }

// d,l,r,u
}
