package com.codingtest.leetcode.medium;

//Link :https://leetcode.com/problems/course-schedule/
public class Course_Schedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        int[] indegree = new int[numCourses];

        for(int i =0 ; i<numCourses; i++) graph[i] = new ArrayList<>();

        for(int i = 0; i<prerequisites.length; i++){
            indegree[prerequisites[i][1]]++;
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0 ; i<numCourses; i++){
            if(indegree[i] == 0) queue.offer(i);
        }

        Set<Integer> visited = new HashSet<>();

        while(!queue.isEmpty()){
            int current = queue.poll();
            visited.add(current);
            for(int dest : graph[current]){
                if(--indegree[dest] ==0) queue.offer(dest);
            }
        }
        return visited.size() == numCourses;
    }


}
