package com.codingtest.programmers.level2;

//Link : https://school.programmers.co.kr/learn/courses/30/lessons/17679
public class 프렌즈_4블록 {
    public int solution(int m, int n, String[] board) {
        char[][] newBoard = new char[m][n];
        char[][] changeBoard = new char[n][m];
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                newBoard[i][j] = board[i].charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                changeBoard[i][j] = newBoard[m - j - 1][i];
            }
        }

        while (true) {
            boolean[][] remove = new boolean[n][m];
            boolean hasRemove = false;

            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < m - 1; j++) {
                    char c = changeBoard[i][j];

                    if (c != '.' &&
                            c == changeBoard[i + 1][j] &&
                            c == changeBoard[i][j + 1] &&
                            c == changeBoard[i + 1][j + 1]) {

                        remove[i][j] = true;
                        remove[i + 1][j] = true;
                        remove[i][j + 1] = true;
                        remove[i + 1][j + 1] = true;
                        hasRemove = true;
                    }
                }
            }

            if (!hasRemove) break;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (remove[i][j]) {
                        changeBoard[i][j] = '.';
                        count++;
                    }
                }
            }

            for(int i =0; i<n; i++){
                for(int j =0; j<m; j++){
                    if(changeBoard[i][j] == '.'){

                        int idx = j +1;

                        while(idx < m && changeBoard[i][idx] =='.'){
                            idx++;
                        }

                        if(idx < m){
                            changeBoard[i][j] = changeBoard[i][idx];
                            changeBoard[i][idx] = '.';
                        }


                    }
                }
            }
        }

        return count;
    }
}
