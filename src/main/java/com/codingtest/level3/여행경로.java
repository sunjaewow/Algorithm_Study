package com.codingtest.level3;
import java.util.*;

public class 여행경로 {
    Map<String, List<Ticket>> map = new HashMap<>();
    List<String> path = new ArrayList<>();
    String[] answer;
    int n;
    public String[] solution(String[][] tickets) {
        n = tickets.length;

        for(String[] ticket : tickets){
            String from = ticket[0];
            String to = ticket[1];

            map.computeIfAbsent(from, k-> new ArrayList<>()).add(new Ticket(to, false));
        }

        for(List<Ticket> list : map.values()){
            list.sort((a,b) -> a.to.compareTo(b.to));
        }

        path.add("ICN");
        dfs("ICN", 0);

        return answer;
    }

    boolean dfs(String current, int count){
        if(count == n){
            answer = path.toArray(String[]::new);
            return true;
        }

        if (!map.containsKey(current)) {
            return false;
        }

        for(Ticket ticket : map.get(current)){
            if(ticket.visited) continue;

            ticket.visited = true;
            path.add(ticket.to);

            if(dfs(ticket.to, count+1)) return true;

            path.remove(path.size()-1);
            ticket.visited = false;
        }
        return false;
    }

    static class Ticket{
        String to;
        boolean visited;

        public Ticket(String to, boolean isVisited){
            this.to = to;
            this.visited = isVisited;
        }
    }
}

/**
 * Map<String, PriorityQueue<String>> map =new HashMap<>();
 *     List<String> list = new ArrayList<>();
 *     public String[] solution(String[][] tickets) {
 *         for(String[] ticket : tickets){
 *             map.computeIfAbsent(ticket[0], k -> new PriorityQueue<>()).add(ticket[1]);
 *         }
 *
 *         dfs("ICN");
 *
 *         Collections.reverse(list);
 *
 *         return list.toArray(String[]::new);
 *
 *     }
 *
 *     void dfs(String current){
 *         PriorityQueue<String> pq = map.get(current);
 *
 *         while(pq !=null && !pq.isEmpty()){
 *             String next = pq.poll();
 *             dfs(next);
 *         }
 *
 *         list.add(current);
 *
 *     }
 */
