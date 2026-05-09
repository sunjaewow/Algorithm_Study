package com.codingtest.level1;

import java.util.*;

public class 체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        List<Integer> reserveList = new ArrayList<>();
        List<Integer> lostList = new ArrayList<>();

        Arrays.sort(lost);

        int count =0;

        for(int r : reserve){
            reserveList.add(r);
        }
        for(int l : lost){
            if(reserveList.contains(l)){
                reserveList.remove(reserveList.indexOf(l));
                continue;
            }
            lostList.add(l);
        }

        for(int l : lostList){
            if(reserveList.contains(l-1)){
                reserveList.remove(reserveList.indexOf(l-1));
            }else if(reserveList.contains(l+1)){
                reserveList.remove(reserveList.indexOf(l+1));
            }else{
                count++;
            }
        }

        return n-count;
    }
}
