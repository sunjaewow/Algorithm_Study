package com.codingtest.leetcode.medium;

//Link : https://leetcode.com/problems/insert-delete-getrandom-o1/description/
public class Insert_Delete_GetRandom_O1 {
    Map<Integer, Integer> map;
    List<Integer> list;
    int length;
    Random r;
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        length = 0;
        r = new Random();
    }

    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        else{
            map.put(val, length++);
            list.add(val);
            return true;
        }
    }

    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        else{
            int removeIndex = map.get(val);
            int lastValue = list.get(list.size()-1);

            list.set(removeIndex, lastValue);
            list.remove(list.size()-1);

            map.put(lastValue, removeIndex);
            map.remove(val);
            length--;
            return true;
        }
    }

    public int getRandom() {
        int idx = r.nextInt(list.size());
        return list.get(idx);
    }
}
