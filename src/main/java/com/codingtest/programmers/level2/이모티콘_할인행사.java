package com.codingtest.programmers.level2;

//Link : https://school.programmers.co.kr/learn/courses/30/lessons/150368
public class 이모티콘_할인행사 {
    int[][] users;
    int[] emoticons;
    int[] discount = {10, 20, 30, 40};
    int[] select;
    int maxJoin;
    int maxPrice;
    public int[] solution(int[][] users, int[] emoticons) {
        this.users = users;
        this.emoticons = emoticons;
        select = new int[emoticons.length];

        dfs(0);

        return new int[]{maxJoin, maxPrice};
    }

    private void dfs(int depth){
        if(depth == emoticons.length){
            calculate();
            return ;
        }

        for(int rate : discount){
            select[depth] = rate;
            dfs(depth+1);
        }
    }

    private void calculate(){
        int joinCount = 0;
        int priceSum = 0;

        for(int[] user : users){
            int sum = 0;
            for(int i =0; i<emoticons.length; i++){
                if(user[0] <= select[i]) sum += emoticons[i] * (100 - select[i])/100;
            }
            if(sum >= user[1]) joinCount++;
            else priceSum += sum;
        }

        if(maxJoin < joinCount){
            maxJoin = joinCount;
            maxPrice = priceSum;
        }else if(maxJoin == joinCount && maxPrice < priceSum) maxPrice = priceSum;
    }
}
