package com.codingtest.leetcode.medium;

//Link :https://leetcode.com/problems/permutations/description/
public class Permutations {
    boolean[] visited;
    List<List<Integer>> list = new ArrayList<>();
    int[] nums;
    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        visited = new boolean[nums.length];

        dfs(new ArrayList<>());

        return list;
    }

    public void dfs(List<Integer> current){
        if(current.size() == nums.length) {
            list.add(new ArrayList<>(current));
            return ;
        }
        for(int i =0; i<nums.length; i++){
            if(!visited[i]){
                visited[i] = true;
                current.add(nums[i]);
                dfs(current);
                current.remove(current.size()-1);
                visited[i] =false;
            }
        }
    }
}
