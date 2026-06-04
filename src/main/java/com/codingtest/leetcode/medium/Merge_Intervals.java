package com.codingtest.leetcode.medium;

//Link : https://leetcode.com/problems/merge-intervals/description/
public class Merge_Intervals {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();

        Arrays.sort(intervals, (a,b)-> {
            if(a[0]== b[0]) return a[1]- b[1];
            return a[0]- b[0];
        });

        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int i = 1; i<intervals.length; i++){
            int currentStart = intervals[i][0];
            int currentEnd = intervals[i][1];

            if(end >= currentStart){
                if(end < currentEnd){
                    end = currentEnd;
                }
            }else{
                list.add(new int[]{start,end});
                start = currentStart;
                end = currentEnd;
            }
        }
        list.add(new int[]{start, end});

        return list.toArray(new int[0][]);
    }
}
