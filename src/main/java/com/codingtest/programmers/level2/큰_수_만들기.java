package com.codingtest.programmers.level2;

public class 큰_수_만들기 {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int length = number.length() - k;

        for(int i = 0; i<number.length(); i++){
            char ch = number.charAt(i);

            while(sb.length()> 0 && k>0 && sb.charAt(sb.length()-1) < ch){
                k--;
                sb.deleteCharAt(sb.length()-1);
            }
            sb.append(ch);
        }
        return sb.substring(0, length);
    }
}
