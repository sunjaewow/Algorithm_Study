package com.codingtest.leetcode.hard;

//Link : https://leetcode.com/problems/sudoku-solver/description/
public class Sudoku_Solver {
    boolean[][] row = new boolean[9][10];
    boolean[][] col = new boolean[9][10];
    boolean[][] sub = new boolean[9][10];
    public void solveSudoku(char[][] board) {
        for(int i =0; i<9; i++){
            for(int j =0; j<9; j++){
                if(board[i][j] == '.') continue;
                int num = board[i][j] - '0';
                int subIdx = (i/3)*3 + j/3;

                row[i][num] = true;
                col[j][num] = true;
                sub[subIdx][num] = true;
            }
        }
        dfs(board);
    }

    public boolean dfs(char[][] board){
        for(int i = 0; i<9; i++){
            for(int j =0; j<9; j++){
                if(board[i][j] != '.') continue;

                int subIdx = (i/3)*3 + j/3;

                for(int k = 1; k<=9; k++){
                    if(row[i][k]) continue;
                    if(col[j][k]) continue;
                    if(sub[subIdx][k]) continue;

                    board[i][j] =(char) (k + '0');

                    row[i][k] = true;
                    col[j][k] = true;
                    sub[subIdx][k] = true;

                    if(dfs(board)) return true;

                    board[i][j] = '.';
                    row[i][k] = false;
                    col[j][k] = false;
                    sub[subIdx][k] = false;

                }
                return false;
            }
        }
        return true;
    }
}
