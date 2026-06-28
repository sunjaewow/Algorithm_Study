package com.codingtest.programmers.level2;

//Link : https://school.programmers.co.kr/learn/courses/30/lessons/42890
public class 후보키 {
    List<List<Integer>> candidateKeys = new ArrayList<>();

    public int solution(String[][] relation) {
        int colSize = relation[0].length;

        for (int size = 1; size <= colSize; size++) {
            dfs(0, size, new ArrayList<>(), relation);
        }

        return candidateKeys.size();
    }

    private void dfs(int start, int targetSize, List<Integer> selected, String[][] relation) {
        if (selected.size() == targetSize) {

            if (!isMinimal(selected)) return;

            if (isUnique(selected, relation)) {
                candidateKeys.add(new ArrayList<>(selected));
            }

            return;
        }

        int colSize = relation[0].length;

        for (int i = start; i < colSize; i++) {
            selected.add(i);
            dfs(i + 1, targetSize, selected, relation);
            selected.remove(selected.size() - 1);
        }
    }

    private boolean isUnique(List<Integer> selected, String[][] relation) {
        Set<String> set = new HashSet<>();

        for (int row = 0; row < relation.length; row++) {
            StringBuilder sb = new StringBuilder();

            for (int col : selected) {
                sb.append(relation[row][col]).append("|");
            }

            set.add(sb.toString());
        }

        return set.size() == relation.length;
    }

    private boolean isMinimal(List<Integer> selected) {
        for (List<Integer> key : candidateKeys) {
            if (selected.containsAll(key)) {
                return false;
            }
        }

        return true;
    }

}
