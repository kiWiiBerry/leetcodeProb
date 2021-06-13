package com.yiyiwii.leetcode.editor.en;

import java.util.*;

public class AmzCostEvalution {
    public static void main(String[] args) {
//        //output = 3
//        int[][] arr = {{0,2},{1,2}};
//        int n = 4;

        //output = 8
        int[][] arr = {{2,6},{3,5},{0,1},{2,9},{5,6}};
        int n = 10;

        AmzCostEvalution.Solution sol = new AmzCostEvalution().new Solution();
        int res = sol.costEvaluation(n, arr);
        System.out.println(res);
    }
    class Solution {

        public int costEvaluation(int n, int[][] connections) {
            if (n <= 1) return n;
            Map<Integer,List<Integer>> graph = new HashMap<>();
//            for (int[] connection : connections) {
//                graph.computeIfAbsent(connection[0], k -> new ArrayList<>()).add(connection[1]);
//                graph.computeIfAbsent(connection[1], k -> new ArrayList<>()).add(connection[0]);
//            }
            for (int i = 0; i < n; i++) {
                graph.put(i, new ArrayList<>());
            }
            for (int[] edge : connections) {
                graph.get(edge[0]).add(edge[1]);
                graph.get(edge[1]).add(edge[0]);
            }

            Set<Integer> visited = new HashSet<>();
            // each unconnected warehouse has a cost of 1
            int cost = n - graph.size();
            for (int node : graph.keySet()) {
                if (!visited.contains(node)) {
                    int groupSize = dfsVisit(graph, visited, node);
                    cost += (int) Math.ceil(Math.sqrt(groupSize));
                }
            }
            return cost;
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
//        public int costEvalution(int n, int[][] connections) {
//            if (n <= 1) return n;
////            Map<Integer, List<Integer>> map = new HashMap<>();
////            for (int i = 0; i < n; i++) {
////                map.put(i, )
////            }
//            List<List<Integer>> adjList = new ArrayList<>();
//            for (int i = 0; i < n; i++) {
//                adjList.add(new ArrayList<Integer>());
//            }
//            for (int[] edge : connections) {
//                adjList.get(edge[0]).add(edge[1]);
//                adjList.get(edge[1]).add(edge[0]);
//            }
//            boolean[] visited = new boolean[n];
//            int cnt = 0;
//            for (int i = 0; i < n; i++) {
//                if
//            }
//        }
    }

}
