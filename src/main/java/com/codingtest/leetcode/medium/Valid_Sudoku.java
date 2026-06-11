package com.codingtest.leetcode.medium;

// Link : https://leetcode.com/problems/valid-sudoku/description/
public class Valid_Sudoku {
    boolean[][] row = new boolean[9][10];
    boolean[][] col = new boolean[9][10];
    boolean[][] sub = new boolean[9][10];

        for(int i = 0; i<9; i++){
        for(int j = 0; j<9; j++){

            if(board[i][j] == '.') continue;

            int num = board[i][j] - '0';
            int idx = (i/3)*3 + j/3;

            if(row[i][num]) return false;
            if(col[j][num]) return false;
            if(sub[idx][num]) return false;

            row[i][num] = true;
            col[j][num] = true;
            sub[idx][num] = true;
        }
    }
        return true;
}
