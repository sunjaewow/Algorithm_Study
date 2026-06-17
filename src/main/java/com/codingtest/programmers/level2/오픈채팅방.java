package com.codingtest.programmers.level2;

//Link : https://school.programmers.co.kr/learn/courses/30/lessons/42888
public class 오픈채팅방 {
    public String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        int len = record.length;
        List<String> answer = new ArrayList<>();

        for(String str : record){
            String[] arr = str.split(" ");
            if(arr[0].equals("Leave")) continue;
            map.put(arr[1], arr[2]);
        }

        for(int i =0; i<len; i++){
            String[] arr = record[i].split(" ");
            String type = arr[0];
            if(type.equals("Enter")){
                answer.add(map.get(arr[1]) +"님이 들어왔습니다.");
            }else if(type.equals("Leave")){
                answer.add(map.get(arr[1]) +"님이 나갔습니다.");
            }
        }

        return answer.toArray(new String[0]);
    }
}
