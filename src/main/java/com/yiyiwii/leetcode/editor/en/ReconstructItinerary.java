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
public class ReconstructItinerary {
    public static void main(String[] args) {
        Solution solution = new ReconstructItinerary().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}