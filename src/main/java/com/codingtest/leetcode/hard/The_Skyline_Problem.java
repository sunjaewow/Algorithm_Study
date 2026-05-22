package com.codingtest.leetcode.hard;

//Link : https://leetcode.com/problems/the-skyline-problem/description/
public class The_Skyline_Problem {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<Building> buildingList = new ArrayList<>();
        List<List<Integer>> answer = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);

        for(int[] building : buildings){
            int startX = building[0];
            int endX = building[1];
            int height = building[2];
            buildingList.add(new Building(startX, height, true));
            buildingList.add(new Building(endX, height, false));
        }

        buildingList.sort((a,b)->a.x - b.x);

        pq.offer(0);
        int maxHeight = 0;
        int i =0;

        while(i<buildingList.size()){
            int currentX = buildingList.get(i).x;

            while(i<buildingList.size() && buildingList.get(i).x == currentX){
                Building building = buildingList.get(i);

                if(building.isStarted){
                    pq.offer(building.height);
                }else{
                    pq.remove(building.height);
                }
                i++;
            }
            int currentHeight = pq.peek();

            if(maxHeight != currentHeight){
                answer.add(List.of(currentX, currentHeight));
                maxHeight = currentHeight;
            }
        }

        return answer;

    }

    static class Building{
        int x;
        int height;
        boolean isStarted;

        public Building(int x, int height, boolean isStarted){
            this.x = x;
            this.height = height;
            this.isStarted = isStarted;
        }
    }
}
