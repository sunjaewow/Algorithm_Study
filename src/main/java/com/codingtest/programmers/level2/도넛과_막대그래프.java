package com.codingtest.programmers.level2;

//Link : https://school.programmers.co.kr/learn/courses/30/lessons/258711
public class 도넛과_막대그래프 {
    public int[] solution(int[][] edges) {
        int max = 0;

        for (int[] edge : edges) {
            max = Math.max(max, Math.max(edge[0], edge[1]));
        }

        int[] in = new int[max + 1];
        int[] out = new int[max + 1];
        boolean[] exist = new boolean[max + 1];

        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];

            out[start]++;
            in[end]++;

            exist[start] = true;
            exist[end] = true;
        }

        int createNode = 0;
        int stick = 0;
        int eight = 0;

        for (int i = 1; i <= max; i++) {
            if (!exist[i]) continue;

            if (in[i] == 0 && out[i] >= 2) {
                createNode = i;
            } else if (out[i] == 0) {
                stick++;
            } else if (in[i] >= 2 && out[i] == 2) {
                eight++;
            }
        }

        int donut = out[createNode] - stick - eight;

        return new int[]{createNode, donut, stick, eight};
    }
}
