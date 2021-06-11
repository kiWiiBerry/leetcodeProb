//We have a list of points on the plane. Find the K closest points to the origin
// (0, 0). 
//
// (Here, the distance between two points on a plane is the Euclidean distance.)
// 
//
// You may return the answer in any order. The answer is guaranteed to be unique
// (except for the order that it is in.) 
//
// 
//
// 
// Example 1: 
//
// 
//Input: points = [[1,3],[-2,2]], K = 1
//Output: [[-2,2]]
//Explanation: 
//The distance between (1, 3) and the origin is sqrt(10).
//The distance between (-2, 2) and the origin is sqrt(8).
//Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
//We only want the closest K = 1 points from the origin, so the answer is just [
//[-2,2]].
// 
//
// 
// Example 2: 
//
// 
//Input: points = [[3,3],[5,-1],[-2,4]], K = 2
//Output: [[3,3],[-2,4]]
//(The answer [[-2,4],[3,3]] would also be accepted.)
// 
//
// 
//
// Note: 
//
// 
// 1 <= K <= points.length <= 10000 
// -10000 < points[i][0] < 10000 
// -10000 < points[i][1] < 10000 
// 
// 
// Related Topics Divide and Conquer Heap Sort 
// 👍 2487 👎 132


package com.yiyiwii.leetcode.editor.en;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    public static void main(String[] args) {
        Solution solution = new KClosestPointsToOrigin().new Solution();
        int[][] points = {{3,3},{5,-1},{-2,4},{1,1},{1,2},{1,-1}};
        int k = 2;
        solution.kClosest(points, 2);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        //Ascending order
        PriorityQueue<int[]> pq = new PriorityQueue<>(K, (b, a) -> a[0] * a[0] + a[1] * a[1] - b[0] * b[0] - b[1] * b[1]);
        for (int[] point : points) {
            pq.offer(point);
            if (pq.size() > K) {
                pq.poll();
            }
        }
//        System.out.println(Arrays.toString(pq.toArray()));
        int[][] res = pq.toArray(new int[K][2]);
        Arrays.sort(res, Comparator.comparing(x -> ((int[])x)[0]).thenComparing(x -> ((int[])x)[1]));
        System.out.println(Arrays.deepToString(res));
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}