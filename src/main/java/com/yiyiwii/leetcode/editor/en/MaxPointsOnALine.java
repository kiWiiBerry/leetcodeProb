//Given n points on a 2D plane, find the maximum number of points that lie on th
//e same straight line. 
//
// Example 1: 
//
// 
//Input: [[1,1],[2,2],[3,3]]
//Output: 3
//Explanation:
//^
//|
//|        o
//|     o
//|  o  
//+------------->
//0  1  2  3  4
// 
//
// Example 2: 
//
// 
//Input: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
//Output: 4
//Explanation:
//^
//|
//|  o
//|     o        o
//|        o
//|  o        o
//+------------------->
//0  1  2  3  4  5  6
// 
//
// NOTE: input types have been changed on April 15, 2019. Please reset to defaul
//t code definition to get new method signature. 
// Related Topics Hash Table Math 
// 👍 1024 👎 2205


package com.yiyiwii.leetcode.editor.en;

import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnALine {
    public static void main(String[] args) {
        Solution solution = new MaxPointsOnALine().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxPoints(int[][] points) {
        HashMap<Double, Integer> map = new HashMap<>();
        int res = 0;   //same = 1, same_y = 1;

        for (int i = 0; i < points.length; i++) {
            int same = 0, same_y = 0;
            int max = 0;
            for (int j = i + 1; j < points.length; j++) {
//                double dx = points[i][0] - points[j][0];
//                double dy = points[i][1] - points[j][1];
//                if (dx == 0.0 && dy == 0.0) {
//                    same++;
//                } else {
//
//                }
//
//                if (points[i][1] == points[j][1]) {
//                    same_y++;
//                    if (points[i][0] == points[j][0]) {
//                        same++;
//                    }
//                } else {
//                    double dx = points[i][0] - points[j][0];
//                    double dy = points[i][1] - points[j][1];
//                    map.put(dx/dy, map.getOrDefault(dx/dy, 1) + 1);
//                }
            }
            res = Math.max(res, same_y);
            for (Map.Entry<Double, Integer> entry : map.entrySet()) {
                res = Math.max(res, same + entry.getValue());
            }
            map.clear();
        }
        return res;
    }
//    public double getSlope(double dx, double dy) {
//        if (dx == 0) return
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

}