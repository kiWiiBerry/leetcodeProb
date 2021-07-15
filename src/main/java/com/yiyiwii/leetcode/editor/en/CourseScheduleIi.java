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
// Return the ordering of courses you should take to finish all courses. If ther
//e are many valid answers, return any of them. If it is impossible to finish all 
//courses, return an empty array. 
//
// 
// Example 1: 
//
// 
//Input: numCourses = 2, prerequisites = [[1,0]]
//Output: [0,1]
//Explanation: There are a total of 2 courses to take. To take course 1 you shou
//ld have finished course 0. So the correct course order is [0,1].
// 
//
// Example 2: 
//
// 
//Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
//Output: [0,2,1,3]
//Explanation: There are a total of 4 courses to take. To take course 3 you shou
//ld have finished both courses 1 and 2. Both courses 1 and 2 should be taken afte
//r you finished course 0.
//So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3
//].
// 
//
// Example 3: 
//
// 
//Input: numCourses = 1, prerequisites = []
//Output: [0]
// 
//
// 
// Constraints: 
//
// 
// 1 <= numCourses <= 2000 
// 0 <= prerequisites.length <= numCourses * (numCourses - 1) 
// prerequisites[i].length == 2 
// 0 <= ai, bi < numCourses 
// ai != bi 
// All the pairs [ai, bi] are distinct. 
// 
// Related Topics Depth-First Search Breadth-First Search Graph Topological Sort
// 
// 👍 4090 👎 175


package com.yiyiwii.leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

public class CourseScheduleIi {
    public static void main(String[] args) {
        Solution solution = new CourseScheduleIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int preq = prerequisites[i][1];
            graph.get(course).add(preq);
        }
        int[] visited = new int[numCourses];
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            if (dfs(i, graph, visited, res)) {
                return new int[0];
            }
        }

        return res.stream().mapToInt(i -> i).toArray();
    }
    public boolean dfs(int curr, ArrayList<ArrayList<Integer>> graph,
                       int[] visited, List<Integer> res) {
        if (visited[curr] == 1) return true;
        if (visited[curr] == 2) return false;
        visited[curr] = 1;
        for (int next : graph.get(curr)) {
            if (dfs(next, graph, visited, res)) {
                return true;
            }
        }
        visited[curr] = 2;
        res.add(curr);
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}