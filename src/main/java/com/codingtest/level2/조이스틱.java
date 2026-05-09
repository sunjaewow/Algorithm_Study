package com.codingtest.level2;

public class 조이스틱 {
    public int solution(String name) {
        int count = 0;
        int length = name.length();
        int move = length-1;
t
        for(int i =0; i<length; i++){
            char ch = name.charAt(i);
            count += Math.min(ch - 'A', 'Z' - ch +1);
            int idx =i+1;
            while(idx < name.length() && name.charAt(idx) == 'A'){
                idx++;
            }
            move = Math.min(move, i*2 + length-idx);
            move = Math.min(move, i +(length-idx)*2);
        }
        return count + move;
    }
}
