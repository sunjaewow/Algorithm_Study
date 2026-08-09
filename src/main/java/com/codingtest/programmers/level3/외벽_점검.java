package com.codingtest.programmers.level3;

//Link : https://school.programmers.co.kr/learn/courses/30/lessons/60062
public class 외벽_점검 {
    import java.util.*;

    class Solution {

        int answer = Integer.MAX_VALUE;
        List<Integer> weakList = new ArrayList<>();

        boolean[] visited;

        int n;
        int[] weak;
        int[] dist;

        public int solution(int n, int[] weak, int[] dist) {

            this.n = n;
            this.weak = weak;
            this.dist = dist;

            visited = new boolean[dist.length];

            // 원형을 직선으로 펼침
            for (int w : weak) {
                weakList.add(w);
            }

            for (int w : weak) {
                weakList.add(w + n);
            }

            dfs(new ArrayList<>(), 0);

            return answer == Integer.MAX_VALUE ? -1 : answer;
        }

        private void dfs(List<Integer> list, int depth) {

            if (depth == dist.length) {
                check(list);
                return;
            }

            for (int i = 0; i < dist.length; i++) {

                if (visited[i]) {
                    continue;
                }

                visited[i] = true;
                list.add(dist[i]);

                // 다음 친구 선택
                dfs(list, depth + 1);

                // 원상복구
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }

        private void check(List<Integer> friends) {

            // 시작 취약점 변경
            for (int start = 0; start < weak.length; start++) {

                int friendIndex = 0;

                int end =
                        weakList.get(start)
                                + friends.get(friendIndex);

                boolean success = true;

                // 취약점 개수만큼 확인
                for (int i = start;
                     i < start + weak.length;
                     i++) {

                    int position = weakList.get(i);

                    if (position > end) {

                        friendIndex++;

                        if (friendIndex == friends.size()) {
                            success = false;
                            break;
                        }

                        end =
                                position
                                        + friends.get(friendIndex);
                    }
                }

                if (success) {
                    answer = Math.min(
                            answer,
                            friendIndex + 1
                    );
                }
            }
        }
    }
}
