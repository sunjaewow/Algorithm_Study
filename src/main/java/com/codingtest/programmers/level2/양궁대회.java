package com.codingtest.programmers.level2;


//Link : https://school.programmers.co.kr/learn/courses/30/lessons/92342
public class 양궁대회 {
    int[] ryon = new int[11];
    int[] answer = {-1};
    int[] info;
    int n;
    int max = 0;
    public int[] solution(int n, int[] info) {
        this.info = info;
        this.n = n;

        dfs(0, 0);

        return answer;
    }

    private void dfs(int depth, int used){
        if(depth == 11){
            ryon[10] = n - used; // 남은 화살 0에다가 다 넣음

            int diff = getDiff();
            if(diff > 0){
                if(diff > max){
                    max = diff;
                    answer = ryon.clone();
                }else if(diff == max && isBetter()) answer = ryon.clone();
            }

            return ;
        }

        int need = info[depth] + 1;

        if(used + need <= n){
            ryon[depth] = need;
            dfs(depth+1, used + need);
            ryon[depth] = 0;
        }

        dfs(depth+1, used);

    }

    private boolean isBetter(){
        for(int i =10; i>=0; i--){
            if(answer[i] == ryon[i]) continue;
            else if(answer[i] > ryon[i]) return false;
            else return true;
        }
        return true;
    }

    private int getDiff(){
        int apeachScore = 0;
        int ryonScore = 0;

        for(int i =0; i<11; i++){
            if(info[i] == 0 && ryon[i] == 0) continue;
            if(info[i] < ryon[i]) ryonScore += 10-i;
            else apeachScore += 10-i;
        }

        return ryonScore - apeachScore;
    }
}
