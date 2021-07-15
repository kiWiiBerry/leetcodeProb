//There are a total of numCourses courses you have to take, labeled from 0 to nu
//mCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai,
// bi] indicates that you must take course bi first if you want to take course ai.
// 
//
// 
// For example, the pair [0, 1], indicates that to take course 0 you have to fir
//st take course 1. 
// 
//
// Return true if you can finish all courses. Otherwise, return false. 
//
// 
// Example 1: 
//
// 
//Input: numCourses = 2, prerequisites = [[1,0]]
//Output: true
//Explanation: There are a total of 2 courses to take. 
//To take course 1 you should have finished course 0. So it is possible.
// 
//
// Example 2: 
//
// 
//Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
//Output: false
//Explanation: There are a total of 2 courses to take. 
//To take course 1 you should have finished course 0, and to take course 0 you s
//hould also have finished course 1. So it is impossible.
// 
//
// 
// Constraints: 
//
// 
// 1 <= numCourses <= 105 
// 0 <= prerequisites.length <= 5000 
// prerequisites[i].length == 2 
// 0 <= ai, bi < numCourses 
// All the pairs prerequisites[i] are unique. 
// 
// Related Topics Depth-First Search Breadth-First Search Graph Topological Sort
// 
// 👍 6273 👎 264


package com.yiyiwii.leetcode.editor.en;

import java.util.ArrayList;

public class CourseSchedule {
    public static void main(String[] args) {
        Solution solution = new CourseSchedule().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int preq = prerequisites[i][1];
            graph.get(course).add(preq);
        }
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (dfs(i, graph, visited)) return false;
        }
        return true;
    }
    private boolean dfs(int curr, ArrayList<ArrayList<Integer>> graph, int[] visited) {
        if (visited[curr] == 1) return true;
        if (visited[curr] == 2) return false;
        visited[curr] = 1;
        for (int next : graph.get(curr)) {
            if (dfs(next, graph, visited)) return true;
        }
        visited[curr] = 2;
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}