package com.steady.leetcode.d7_back;

import java.util.*;

/**
 * 输入：tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * <br>
 * 输出：["JFK","ATL","JFK","SFO","ATL","SFO"]
 */
public class ReArrangeRoad {
    private Deque<String> res;
    private Map<String, Map<String, Integer>> map;
    
    
    public List<String> findItinerary(List<List<String>> tickets) {
        map = new HashMap<>();
        res = new LinkedList<>();
        for (List<String> t : tickets) {
            Map<String, Integer> temp;
            if (map.containsKey(t.get(0))) {
                temp = map.get(t.get(0));
                temp.put(t.get(1), temp.getOrDefault(t.get(1), 0) + 1);
            } else {
                temp = new TreeMap<>();//升序Map
                temp.put(t.get(1), 1);
            }
            map.put(t.get(0), temp);
            
        }
        res.add("JFK");
        backTracking(tickets.size());
        return new ArrayList<>(res);
    }
    private boolean backTracking(int ticketNum) {
        if (res.size() == ticketNum + 1) {
            return true;
        }
        String last = res.getLast();
        if (map.containsKey(last)) {          //防止出现null
            for (Map.Entry<String, Integer> target : map.get(last).entrySet()) {
                int count = target.getValue();
                if (count > 0) {
                    res.add(target.getKey());
                    target.setValue(count - 1);
                    if (backTracking(ticketNum)) return true;
                    res.removeLast();
                    target.setValue(count);
                }
            }
        }
        return false;
    }
}