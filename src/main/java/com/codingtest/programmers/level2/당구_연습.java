package com.codingtest.programmers.level2;

//Link : https://school.programmers.co.kr/learn/courses/30/lessons/169198
public class 당구_연습 {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        int idx =0;

        for(int[] ball : balls){
            int min = Integer.MAX_VALUE;
            List<int[]> list = new ArrayList<>();

            int x = ball[0];
            int y = ball[1];

            int distX = m - x;
            int distY = n - y;

            list.add(new int[]{-x, y});
            list.add(new int[]{x, -y});
            list.add(new int[]{x, y + distY*2});
            list.add(new int[]{x + distX*2, y});

            for(int i = 0; i<4; i++){
                int[] current = list.get(i);

                if (i == 0 && startY == y && startX > x) continue;
                if (i == 1 && startX == x && startY > y) continue;
                if (i == 2 && startX == x && startY < y) continue;
                if (i == 3 && startY == y && startX < x) continue;
                int value = (int)Math.pow(current[0] - startX,2) +
                        (int)Math.pow(current[1] - startY, 2);

                min = Math.min(min, value);
            }

            answer[idx++] = min;
        }
        return answer;
    }
}
