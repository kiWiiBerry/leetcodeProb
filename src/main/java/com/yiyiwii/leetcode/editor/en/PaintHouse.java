/** 256 Paint House
 * There are a row of n houses, each house can be painted with one of
 * the three colors: red, blue or green. The cost of painting each
 * house with a certain color is different. You have to paint all the
 * houses such that no two adjacent houses have the same color.
 *
 * The cost of painting each house with a certain color is represented
 * by a n x 3 cost matrix. For example, costs[0][0] is the cost of
 * painting house 0 with color red; costs[1][2] is the cost of painting
 * house 1 with color green, and so on... Find the minimum cost to
 * paint all houses.
 * Input:
 *       R  B  G
 *     [[17,2,17],
 *      [16,16,5],
 *      [14,3,19],
 *      [24,2,40]]
 * */

package com.yiyiwii.leetcode.editor.en;

public class PaintHouse {

class Solution {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }

        int[][] res = new int[costs.length][3];
        for (int i = 0; i < costs.length; i++) {
            if (i == 0) {
                res[0][i] = costs[i][0];
                res[1][i] = costs[i][1];
                res[2][i] = costs[i][2];
            } else {
                res[0][i] = costs[i][0] + Math.min(res[1][i - 1], res[2][i - 1]);
                res[1][i] = costs[i][1] + Math.min(res[0][i - 1], res[2][i - 1]);
                res[2][i] = costs[i][0] + Math.min(res[0][i - 1], res[1][i - 1]);
            }
        }
        int minTmp = Math.min(res[0][costs.length - 1], res[1][costs.length - 1]);

        return Math.min(minTmp, res[2][costs.length - 1]);
    }
}

}
