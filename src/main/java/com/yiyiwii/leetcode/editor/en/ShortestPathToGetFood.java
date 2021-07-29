//You are starving and you want to eat food as quickly as possible. You want to 
//find the shortest path to arrive at any food cell. 
//
// You are given an m x n character matrix, grid, of these different types of ce
//lls: 
//
// 
// '*' is your location. There is exactly one '*' cell. 
// '#' is a food cell. There may be multiple food cells. 
// 'O' is free space, and you can travel through these cells. 
// 'X' is an obstacle, and you cannot travel through these cells. 
// 
//
// You can travel to any adjacent cell north, east, south, or west of your curre
//nt location if there is not an obstacle. 
//
// Return the length of the shortest path for you to reach any food cell. If the
//re is no path for you to reach food, return -1. 
//
// 
// Example 1: 
//
// 
//Input: grid = [["X","X","X","X","X","X"],["X","*","O","O","O","X"],["X","O","O
//","#","O","X"],["X","X","X","X","X","X"]]
//Output: 3
//Explanation: It takes 3 steps to reach the food.
// 
//
// Example 2: 
//
// 
//Input: grid = [["X","X","X","X","X"],["X","*","X","O","X"],["X","O","X","#","X
//"],["X","X","X","X","X"]]
//Output: -1
//Explanation: It is not possible to reach the food.
// 
//
// Example 3: 
//
// 
//Input: grid = [["X","X","X","X","X","X","X","X"],["X","*","O","X","O","#","O",
//"X"],["X","O","O","X","O","O","X","X"],["X","O","O","O","O","#","O","X"],["X","X
//","X","X","X","X","X","X"]]
//Output: 6
//Explanation: There can be multiple food cells. It only takes 6 steps to reach 
//the bottom food. 
//
// Example 4: 
//
// 
//Input: grid = [["O","*"],["#","O"]]
//Output: 2
// 
//
// Example 5: 
//
// 
//Input: grid = [["X","*"],["#","X"]]
//Output: -1
// 
//
// 
// Constraints: 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 200 
// grid[row][col] is '*', 'X', 'O', or '#'. 
// The grid contains exactly one '*'. 
// 
// Related Topics Array Breadth-First Search Matrix 
// 👍 128 👎 7


package com.yiyiwii.leetcode.editor.en;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathToGetFood {
    public static void main(String[] args) {
        Solution solution = new ShortestPathToGetFood().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int getFood(char[][] grid) {
            Queue<int[]> queue = new LinkedList<>();
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == '*') {
                        queue.offer(new int[]{i, j});
                    }
                }
            }
            int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
            int lev = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int[] curr = queue.poll();

                    grid[curr[0]][curr[1]] = 'X';
                    for (int k = 0; k < dirs.length; k++) {
                        int newR = curr[0] + dirs[k][0];
                        int newC = curr[1] + dirs[k][1];

                        if (newR >= 0 && newR < grid.length &&
                                newC >= 0 && newC < grid[0].length &&
                                grid[newR][newC] == 'O'){
                            queue.offer(new int[]{newR, newC});
                        }
                    }
                }
                lev++;
            }
            return -1;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}