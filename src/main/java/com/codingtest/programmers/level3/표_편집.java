package com.codingtest.programmers.level3;

//Link : https://school.programmers.co.kr/learn/courses/30/lessons/81303
public class 표_편집 {


    class Solution {
        public String solution(int n, int k, String[] cmd) {
            List<Integer> originList = new ArrayList<>();
            for(int i =0; i<n; i++) originList.add(i);
            Stack<int[]> remove = new Stack<>();

            int idx = k;

            for(String command : cmd){
                char type = command.charAt(0);

                if(type == 'D'){
                    int number = Integer.parseInt(command.substring(2));
                    idx+=number;
                }else if(type =='U'){
                    int number = Integer.parseInt(command.substring(2));
                    idx-=number;
                }else if(type =='C'){
                    int originIdx = originList.remove(idx);
                    remove.push(new int[]{idx, originIdx});

                    if(idx == originList.size())idx--;
                }else{
                    int[] current = remove.pop();
                    originList.add(current[0], current[1]);

                    if(current[0] <= idx) idx++;
                }
            }

            char[] answer = new char[n];

            Arrays.fill(answer, 'X');

            for (int originIdx : originList) {
                answer[originIdx] = 'O';
            }

            return new String(answer);

        }
    }
}
