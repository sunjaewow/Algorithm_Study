package com.codingtest.leetcode.medium;

//Link : https://leetcode.com/problems/letter-case-permutation/description/
public class Letter_Case_Permutation {
    Set<String> answer = new HashSet<>();
    char[] arr;
    int len;
    public List<String> letterCasePermutation(String s) {
        arr = s.toCharArray();
        len = s.length();

        dfs("", 0);

        return new ArrayList<>(answer);
    }

    public void dfs(String current, int idx){
        if(current.length() == len) {
            answer.add(current);
            return ;
        }

        if(Character.isDigit(arr[idx])) {
            dfs(current + arr[idx], idx+1);
            return ;
        }

        char ch = Character.toUpperCase(arr[idx]);
        dfs(current + ch, idx+1);

        ch = Character.toLowerCase(arr[idx]);
        dfs(current + ch, idx+1);
    }
}
