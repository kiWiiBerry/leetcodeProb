//You have a graph of n nodes. You are given an integer n and an array edges whe
//re edges[i] = [ai, bi] indicates that there is an edge between ai and bi in the 
//graph. 
//
// Return the number of connected components in the graph. 
//
// 
// Example 1: 
//
// 
//Input: n = 5, edges = [[0,1],[1,2],[3,4]]
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: n = 5, edges = [[0,1],[1,2],[2,3],[3,4]]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 2000 
// 1 <= edges.length <= 5000 
// edges[i].length == 2 
// 0 <= ai <= bi < n 
// ai != bi 
// There are no repeated edges. 
// 
// Related Topics Depth-first Search Breadth-first Search Union Find Graph 
// 👍 1316 👎 37


package com.yiyiwii.leetcode.editor.en;

import java.util.*;

public class NumberOfConnectedComponentsInAnUndirectedGraph {
    public static void main(String[] args) {
        Solution solution = new NumberOfConnectedComponentsInAnUndirectedGraph().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countComponents(int n, int[][] edges) {
        if (n <= 1) return n;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();
        // each unconnected warehouse has a cost of 1
        int cost = n - graph.size();
        int cnt = 0;
        for (int node : graph.keySet()) {
            if (!visited.contains(node)) {
                int groupSize = dfsVisit(graph, visited, node);
                cost += (int) Math.ceil(Math.sqrt(groupSize));
                cnt++;
            }
        }
//        return cost;
        return cnt;
    }
    private int dfsVisit(Map<Integer,List<Integer>> graph, Set<Integer> visited, int node) {
        visited.add(node);

        int length = 1;
        for (int adjNode : graph.get(node)) {
            if (!visited.contains(adjNode)) {
                length += dfsVisit(graph, visited, adjNode);
            }
        }
        return length;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}