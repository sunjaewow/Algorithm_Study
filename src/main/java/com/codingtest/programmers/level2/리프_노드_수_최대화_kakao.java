package com.codingtest.programmers.level2;

//Link : https://school.programmers.co.kr/learn/courses/30/lessons/468372
public class 리프_노드_수_최대화_kakao {
    int answer = 1;
    int dist_limit;
    int split_limit;
    public int solution(int dist_limit, int split_limit) {
        this.dist_limit = dist_limit;
        this.split_limit = split_limit;
        if(dist_limit == 0) return 1;
        dfs(1, 1, 1, 0);
        return answer;
    }

    public void dfs(int cur, int count, int split, int leaf){
        if(split > split_limit) return ;

        answer = Math.max(answer, cur + leaf);

        for(int i =2; i<=3; i++){
            int nextSplit = split * i;

            if(nextSplit > split_limit) break;

            int nextNodeCnt = cur * i;

            int nextCur = Math.min(nextNodeCnt, dist_limit - count);

            int nextLeaf = leaf + (nextNodeCnt - nextCur);

            dfs(nextCur, count + nextCur, nextSplit, nextLeaf);
        }
    }
}
