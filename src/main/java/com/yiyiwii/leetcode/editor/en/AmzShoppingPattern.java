package com.yiyiwii.leetcode.editor.en;

import java.util.*;

public class AmzShoppingPattern {
    public static void main(String[] args) {
        int[][] edges = {{1,2},{1,3},{3,2},{4,1},{5,2},{3,6}};
        int n = 6;
        AmzShoppingPattern.Solution sol = new AmzShoppingPattern().new Solution();
        int res = sol.shoppingPattern(n, edges);
        System.out.println(res);
//        Set<Integer>[] g = sol.buildGraph(n, edges);
//        System.out.println(Arrays.toString(g));
    }
    class Solution {
        public int shoppingPattern(int n, int[][] edges) {
            Set<Integer>[] graph = buildGraph(n, edges);
            int res = Integer.MAX_VALUE;
            for (int i = 1; i < graph.length; i++) {
                if (graph[i].size() >= 2) {
                    List<Integer> neighbors = new ArrayList<>(graph[i]);
                    for (int j = 0; j < neighbors.size(); j++) {
                        int nodeA = neighbors.get(j);
                        for (int k = j + 1; k < neighbors.size(); k++) {
                            int nodeB = neighbors.get(k);
                            if (graph[nodeA].contains(nodeB)) {
                                int degree = graph[i].size() + graph[nodeA].size() + graph[nodeB].size() - 6;
                                res = Math.min(res, degree);
                            }
                        }
                    }
                }
            }
            return res == Integer.MAX_VALUE ? -1 : res;
        }
        public Set<Integer>[] buildGraph(int n, int[][] edges) {
            Set<Integer>[] graph = new HashSet[n + 1];
            for (int i = 0; i< graph.length; i++) {
                graph[i] = new HashSet<Integer>();
            }
            for (int[] e : edges) {
                graph[e[0]].add(e[1]);
                graph[e[1]].add(e[0]);
            }
            return graph;
        }
    }
}
