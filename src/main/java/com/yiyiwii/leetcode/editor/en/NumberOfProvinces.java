//There are n cities. Some of them are connected, while some are not. If city a 
//is connected directly with city b, and city b is connected directly with city c,
// then city a is connected indirectly with city c. 
//
// A province is a group of directly or indirectly connected cities and no other
// cities outside of the group. 
//
// You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the 
//ith city and the jth city are directly connected, and isConnected[i][j] = 0 othe
//rwise. 
//
// Return the total number of provinces. 
//
// 
// Example 1: 
//
// 
//Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
//Output: 3
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 200 
// n == isConnected.length 
// n == isConnected[i].length 
// isConnected[i][j] is 1 or 0. 
// isConnected[i][i] == 1 
// isConnected[i][j] == isConnected[j][i] 
// 
// Related Topics Depth-first Search Union Find 
// 👍 3150 👎 190


package com.yiyiwii.leetcode.editor.en;
public class NumberOfProvinces {
    public static void main(String[] args) {
        Solution solution = new NumberOfProvinces().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int[] visited = new int[isConnected.length];
        int cnt = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (visited[i] != 1) {
                dfs(isConnected, visited, i);
                cnt++;
            }
        }
        return cnt;
    }
    public void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < visited.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}