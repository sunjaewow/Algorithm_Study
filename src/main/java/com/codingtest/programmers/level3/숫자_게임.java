package com.codingtest.programmers.level3;

//Link : https://school.programmers.co.kr/learn/courses/30/lessons/12987
public class 숫자_게임 {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        int idx2 = B.length-1;
        Arrays.sort(A);
        Arrays.sort(B);

        for(int i = A.length-1; i>=0; i--){
            if(A[i] < B[idx2]){
                idx2--;
                answer++;
            }


        }


        return answer;
    }
}
