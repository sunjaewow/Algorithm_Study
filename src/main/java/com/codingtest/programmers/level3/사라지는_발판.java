package com.codingtest.programmers.level3;

//Link ;https://school.programmers.co.kr/learn/courses/30/lessons/92345
public class 사라지는_발판 {
    class Solution {
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};
        int[][] board;
        int w;
        int h;
        public int solution(int[][] board, int[] aloc, int[] bloc) {
            this.board = board;
            w = board[0].length;
            h = board.length;
            return dfs(aloc[0], aloc[1], bloc[0], bloc[1]).moveCount;
        }

        private Result dfs(int curY, int curX, int oppY, int oppX){
            if(board[curY][curX] == 0) return new Result(false, 0);

            int minWinCount = Integer.MAX_VALUE;
            int maxLoseCount = 0;
            boolean isMove = false;

            for(int i =0; i<4; i++){
                int nextY = curY + dy[i];
                int nextX = curX + dx[i];

                if(nextX >= 0 && nextX < w && nextY >=0 && nextY < h && board[nextY][nextX] == 1){
                    isMove = true;
                    board[curY][curX] = 0;

                    Result result = dfs(oppY, oppX, nextY, nextX);

                    int totalMoveCount = result.moveCount +1;

                    board[curY][curX] = 1;

                    if(result.isWin) maxLoseCount = Math.max(maxLoseCount, totalMoveCount);
                    else minWinCount = Math.min(minWinCount, totalMoveCount);
                }
            }

            if(!isMove) return new Result(false, 0);

            if(minWinCount != Integer.MAX_VALUE) return new Result(true, minWinCount);

            return new Result(false, maxLoseCount);
        }



        static class Result{
            boolean isWin;
            int moveCount;

            public Result(boolean isWin, int moveCount){
                this.isWin = isWin;
                this.moveCount = moveCount;
            }
        }
    }

}
