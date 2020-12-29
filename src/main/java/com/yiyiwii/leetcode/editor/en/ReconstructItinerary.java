//Given a list of airline tickets represented by pairs of departure and arrival 
//airports [from, to], reconstruct the itinerary in order. All of the tickets belo
//ng to a man who departs from JFK. Thus, the itinerary must begin with JFK. 
//
// Note: 
//
// 
// If there are multiple valid itineraries, you should return the itinerary that
// has the smallest lexical order when read as a single string. For example, the i
//tinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"]. 
// All airports are represented by three capital letters (IATA code). 
// You may assume all tickets form at least one valid itinerary. 
// One must use all the tickets once and only once. 
// 
//
// Example 1: 
//
// 
//Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
//Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
// 
//
// Example 2: 
//
// 
//Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
//
//Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
//Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL"
//,"SFO"].
//             But it is larger in lexical order.
// 
// Related Topics Depth-first Search Graph 
// 👍 2284 👎 1131


package com.yiyiwii.leetcode.editor.en;

import java.util.*;

public class ReconstructItinerary {
    public static void main(String[] args) {
        Solution solution = new ReconstructItinerary().new Solution();
        List<List<String>> flights = new ArrayList(Arrays.asList(
                Arrays.asList("MUC", "LHR"),Arrays.asList("JFK", "MUC"),
                Arrays.asList("SFO", "SJC"),Arrays.asList("LHR", "SFO")
        ));
        HashMap<String, PriorityQueue<String>> graph = solution.buildMap(flights);
        solution.printGraph(graph);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> res = new ArrayList<>();
        if (tickets == null || tickets.size() == 0) return res;
        HashMap<String, PriorityQueue<String>> map = new HashMap<>();
        for (List<String> t : tickets) {
            map.putIfAbsent(t.get(0), new PriorityQueue<String>());
            map.get(t.get(0)).offer(t.get(1));
        }
        Stack<String> s = new Stack();
        s.push("JFK");
        while (!s.isEmpty()) {
            String next = s.peek();

            if (map.get(next) != null && !map.get(next).isEmpty() ) {
                s.push(map.get(next).poll());
            } else {
                res.add(0, next);
                s.pop();
            }
        }

        return res;
    }
    public HashMap<String, PriorityQueue<String>> buildMap(List<List<String>> tickets) {
        HashMap<String, PriorityQueue<String>> map = new HashMap<>();
        for (List<String> t : tickets) {
            map.putIfAbsent(t.get(0), new PriorityQueue<String>());
            map.get(t.get(0)).offer(t.get(1));
        }
        return map;
    }
    public void printGraph(HashMap<String, PriorityQueue<String>> graph) {
        for (Map.Entry<String, PriorityQueue<String>> entry : graph.entrySet()) {
            System.out.println("key: " + entry.getKey() + ", value: " + entry.getValue().toString());
        }
    }
//    public void dfs(String from, Map<String, PriorityQueue<String>> flights,
//                    List<String> res) {
//        PriorityQueue<String> nexts = flights.get(from);
//        while ()
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

}