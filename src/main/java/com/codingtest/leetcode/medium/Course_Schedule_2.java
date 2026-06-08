package com.codingtest.leetcode.medium;

// Link :https://leetcode.com/problems/course-schedule-ii/
public class Course_Schedule_2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        List<Integer> answer = new ArrayList<>();
        int[] indegree = new int[numCourses];

        if(numCourses == 1 )return new int[]{0};

        for(int i = 0; i< numCourses; i++)graph[i] = new ArrayList<>();

        for(int[] prerequisite : prerequisites){
            indegree[prerequisite[0]]++;
            graph[prerequisite[1]].add(prerequisite[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i =0; i<numCourses; i++){
            if(indegree[i] == 0) queue.offer(i);
        }
        Set<Integer> visited = new HashSet<>();

        while(!queue.isEmpty()){
            int current = queue.poll();
            visited.add(current);
            answer.add(current);
            for(int dest : graph[current]){
                if(--indegree[dest] == 0) queue.offer(dest);
            }
        }
        return visited.size() == numCourses ? answer.stream().mapToInt(Integer::intValue).toArray() : new int[]{};
    }
}
