package com.codingtest.programmers.level3;

//Link : https://school.programmers.co.kr/learn/courses/30/lessons/64062
public class 징검다리_건너기 {
    public int solution(int[] stones, int k) {
        PriorityQueue<Stone> pq = new PriorityQueue<>((a,b)->{
            if(a.count == b.count) return a.idx - b.idx;
            return a.count - b.count;
        });
        TreeSet<Integer> set = new TreeSet<>();
        set.add(-1);
        set.add(stones.length);

        for(int i = 0; i<stones.length; i++){
            pq.offer(new Stone(i, stones[i]));
            set.add(i);
        }

        while(!pq.isEmpty()){
            Stone current = pq.poll();
            set.remove(current.idx);

            int left = set.lower(current.idx);
            int right = set.higher(current.idx);

            int breakCount = right - left -1;

            if(breakCount >= k)return current.count;

        }

        return 0;
    }

    static class Stone{
        int idx;
        int count;

        public Stone(int idx, int count){
            this.idx = idx;
            this.count = count;
        }
    }
}
