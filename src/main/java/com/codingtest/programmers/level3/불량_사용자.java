package com.codingtest.programmers.level3;

//Link : https://school.programmers.co.kr/learn/courses/30/lessons/64064
public class 불량_사용자 {
    int count = 0;
    Map<String, List<String>> map = new HashMap<>();
    Set<String> result = new HashSet<>();
    String[] banned_id;
    int n;
    public int solution(String[] user_id, String[] banned_id) {
        n = banned_id.length;
        this.banned_id = banned_id;

        for(String banned : banned_id){
            int banLen = banned.length();
            if(map.containsKey(banned))continue;

            for(String user : user_id){
                int userLen = user.length();

                if(banLen != userLen) continue;

                boolean isRight = true;

                for(int i =0; i<banLen; i++){
                    if(banned.charAt(i) == '*') continue;
                    if(banned.charAt(i) != user.charAt(i)){
                        isRight = false;
                        break;
                    }
                }
                if(isRight) map.computeIfAbsent(banned, k-> new ArrayList<>()).add(user);
            }
        }

        dfs(new ArrayList<>(), 0);

        return result.size();

    }

    private void dfs(List<String> list, int depth){
        if(depth == n){
            List<String> newList = new ArrayList<>(list);
            Collections.sort(newList);
            result.add(String.join(",", newList));
            return ;

        }

        String banned = banned_id[depth];

        for(String users : map.get(banned)){
            if(list.contains(users)) continue;

            list.add(users);
            dfs(list, depth +1);
            list.remove(users);
        }
    }


    import java.util.*;

    class Solution {
        boolean[] visited;
        String[] banned_id;
        int n;
        Map<String, Integer> userMap = new HashMap<>();
        Map<String, Set<String>> banCandidateMap = new HashMap<>();
        Set<Set<String>> result = new HashSet<>();
        Set<String> selected = new HashSet<>();

        public int solution(String[] user_id, String[] banned_id) {
            this.banned_id = banned_id;
            n = banned_id.length;
            visited = new boolean[user_id.length];

            for(int i = 0; i<user_id.length; i++){
                userMap.put(user_id[i], i);
            }

            for(String b : banned_id){
                int banLen = b.length();
                for(String u : user_id){
                    int userLen = u.length();
                    if(userLen != banLen) continue;

                    boolean isCandidate = true;

                    for(int i =0; i<banLen; i++){
                        char banChar = b.charAt(i);
                        char userChar = u.charAt(i);
                        if(banChar == '*') continue;
                        if(banChar != userChar){
                            isCandidate = false;
                            break;
                        }
                    }
                    if(isCandidate) banCandidateMap.computeIfAbsent(b, k -> new HashSet<>()).add(u);
                }
            }

            dfs(0);
            return result.size();
        }

        private void dfs(int depth){
            if(depth == n){
                result.add(new HashSet<>(selected));
                return ;
            }

            for(String candidate : banCandidateMap.get(banned_id[depth])){
                int idx = userMap.get(candidate);
                if(visited[idx]) continue;
                selected.add(candidate);
                visited[idx] = true;

                dfs(depth+1);

                selected.remove(candidate);
                visited[idx] = false;
            }
        }
    }
}
