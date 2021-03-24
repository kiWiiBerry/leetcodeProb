/**
 * 265. Paint House II
 * There are a row of n houses, each house can be painted with one of the k colors. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.
 *
 * The cost of painting each house with a certain color is represented by a n x k cost matrix. For example, costs[0][0] is the cost of painting house 0 with color 0; costs[1][2] is the cost of painting house 1 with color 2, and so on... Find the minimum cost to paint all houses.
 *
 * Note:
 * All costs are positive integers.
 * Input: [[1,5,3],[2,9,4]]
 * Output: 5
 * Explanation: Paint house 0 into color 0, paint house 1 into color 2. Minimum cost: 1 + 4 = 5;
 *              Or paint house 0 into color 2, paint house 1 into color 0. Minimum cost: 3 + 2 = 5.
 * */
package com.yiyiwii.leetcode.editor.en;

public class PaintHouseIi {

    class Solution {
        public int minCost(int[][] costs) {
            if (costs == null || costs.length == 0) return 0;
            int iLen = costs.length;
            int jLen = costs[0].length;
            int[][] dp = new int[iLen][jLen];

            int min1 = -1, min2 = -1;
            for (int i = 0; i < iLen; i++) {
                int last1 = min1, last2 = min2;
                min1 = -1; min2 = -1;
                for (int j = 0; j < jLen; j++) {
                    if (j != last1) {
                        dp[i][j] += last1 < 0 ? 0 : dp[i - 1][last1];
                    } else {
                        dp[i][j] += last2 < 0 ? 0 : dp[i - 1][last2];
                    }
                    if (min1 < 0 || dp[i][j] < dp[i][min1]) {
                        min2 = min1; min1 = j;
                    } else if (min2 < 0 || dp[i][j] < dp[i][min2]) {
                        min2 = j;
                    }
                }
            }
            return dp[iLen - 1][min1];
        }
    }
}
