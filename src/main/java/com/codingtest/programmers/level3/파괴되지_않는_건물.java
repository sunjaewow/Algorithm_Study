package com.codingtest.programmers.level3;

//Link : https://school.programmers.co.kr/learn/courses/30/lessons/92344
public class 파괴되지_않는_건물 {
    public int solution(int[][] board, int[][] skill) {
        int n = board.length;
        int m = board[0].length;

        int[][] sum = new int[n+1][m+1];

        for(int[] s : skill){
            int type = s[0];
            int y1 = s[1];
            int x1 = s[2];
            int y2 = s[3];
            int x2 = s[4];
            int degree = s[5];

            int value = type ==1 ? -degree : degree;

            sum[y1][x1] += value;
            sum[y1][x2+1] -= value;
            sum[y2+1][x1] -= value;
            sum[y2+1][x2+1] += value;
        }

        int answer = 0;

        for(int i = 0; i<n; i++){
            for(int j =1; j<m; j++){
                sum[i][j] += sum[i][j-1];
            }
        }

        for(int i= 0; i<m; i++){
            for(int j =1; j<n; j++){
                sum[j][i] += sum[j-1][i];
            }
        }

        for(int i =0; i<n; i++){
            for(int j =0; j<m; j++){
                if(board[i][j] + sum[i][j]>0)answer++;
            }
        }

        return answer;
    }
}
