package com.codingtest.programmers.level3;

import java.util.*;

public class 퍼즐_조각_채우기 {
    int[] dx = new int[]{0,0,-1,1};
    int[] dy = new int[]{-1,1, 0, 0};

    public int solution(int[][] game_board, int[][] table) {
        List<List<int[]>> empty = findPlace(game_board, 0);
        List<List<int[]>> puzzle = findPlace(table, 1);
        List<Integer> check = new ArrayList<>();

        int count = 0;

        for(List<int[]> list : empty){
            for(int i = 0; i<puzzle.size(); i++){
                if(!check.contains(i) && list.size()==puzzle.get(i).size()
                        && isRight(list, puzzle.get(i))) {
                    count+= list.size();
                    check.add(i);
                    break;
                }
            }
        }
        return count;
    }

    public boolean isRight(List<int[]> emptyList, List<int[]> puzzleList){
        List<int[]> list = puzzleList;
        for(int i = 0; i<4; i++){

            boolean isRight = true;

            for(int j =0; j<emptyList.size(); j++){
                if(emptyList.get(j)[0] != list.get(j)[0]
                        ||emptyList.get(j)[1] != list.get(j)[1]){
                    isRight = false;
                    break;
                }
            }

            if(isRight) return true;

            list = change(list);
        }
        return false;
    }

    public List<int[]> change(List<int[]> list){
        List<int[]> answer = new ArrayList<>();
        for(int[] l : list){
            int x = l[1];
            int y = l[0];

            answer.add(new int[]{x, -y});
        }
        return nomalize(answer);
    }

    public List<List<int[]>> findPlace(int[][] array, int target){
        int n = array.length;
        boolean[][] visited = new boolean[n][n];
        List<List<int[]>> result = new ArrayList<>();

        for(int i = 0; i< n; i++){
            for(int j = 0; j<n; j++){
                List<int[]> place = new ArrayList<>();
                if(array[i][j] == target && !visited[i][j]){
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i,j});
                    visited[i][j] = true;
                    place.add(new int[]{i,j});

                    while(!queue.isEmpty()){
                        int[] current = queue.poll();
                        int x = current[1];
                        int y = current[0];

                        for(int k =0; k<4; k++){
                            int nextX = x + dx[k];
                            int nextY = y + dy[k];

                            if(nextX >=0 && nextX <n && nextY >=0 && nextY <n
                                    && array[nextY][nextX] == target && !visited[nextY][nextX]){
                                visited[nextY][nextX] = true;
                                queue.offer(new int[]{nextY, nextX});
                                place.add(new int[]{nextY,nextX});
                            }
                        }
                    }
                    result.add(nomalize(place));
                }

            }
        }

        return result;
    }

    public List<int[]> nomalize(List<int[]> list){
        int x = Integer.MAX_VALUE;
        int y = Integer.MAX_VALUE;

        for(int[] l : list){
            x = Math.min(x, l[1]);
            y = Math.min(y, l[0]);
        }

        for(int[] l : list){
            l[0] -= y;
            l[1] -= x;
        }

        list.sort((a,b) -> {
            if(a[0] == b[0])return a[1] - b[1];
            return a[0] - b[0];
        });
        return list;
    }
}
