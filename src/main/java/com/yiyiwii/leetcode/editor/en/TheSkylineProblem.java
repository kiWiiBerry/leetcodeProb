//A city's skyline is the outer contour of the silhouette formed by all the buil
//dings in that city when viewed from a distance. Given the locations and heights 
//of all the buildings, return the skyline formed by these buildings collectively.
// 
//
// The geometric information of each building is given in the array buildings wh
//ere buildings[i] = [lefti, righti, heighti]: 
//
// 
// lefti is the x coordinate of the left edge of the ith building. 
// righti is the x coordinate of the right edge of the ith building. 
// heighti is the height of the ith building. 
// 
//
// You may assume all buildings are perfect rectangles grounded on an absolutely
// flat surface at height 0. 
//
// The skyline should be represented as a list of "key points" sorted by their x
//-coordinate in the form [[x1,y1],[x2,y2],...]. Each key point is the left endpoi
//nt of some horizontal segment in the skyline except the last point in the list, 
//which always has a y-coordinate 0 and is used to mark the skyline's termination 
//where the rightmost building ends. Any ground between the leftmost and rightmost
// buildings should be part of the skyline's contour. 
//
// Note: There must be no consecutive horizontal lines of equal height in the ou
//tput skyline. For instance, [...,[2 3],[4 5],[7 5],[11 5],[12 7],...] is not acc
//eptable; the three lines of height 5 should be merged into one in the final outp
//ut as such: [...,[2 3],[4 5],[12 7],...] 
//
// 
// Example 1: 
//
// 
//Input: buildings = [[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]
//Output: [[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]
//Explanation:
//Figure A shows the buildings of the input.
//Figure B shows the skyline formed by those buildings. The red points in figure
// B represent the key points in the output list.
// 
//
// Example 2: 
//
// 
//Input: buildings = [[0,2,3],[2,5,3]]
//Output: [[0,3],[5,0]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= buildings.length <= 104 
// 0 <= lefti < righti <= 231 - 1 
// 1 <= heighti <= 231 - 1 
// buildings is sorted by lefti in non-decreasing order. 
// 
// Related Topics Divide and Conquer Heap Binary Indexed Tree Segment Tree Line 
//Sweep 
// 👍 2556 👎 144


package com.yiyiwii.leetcode.editor.en;

import java.util.*;

public class TheSkylineProblem {
    public static void main(String[] args) {
        Solution solution = new TheSkylineProblem().new Solution();
        int[][] buildings = {{1,10001,10000},{3000,10001,13001},{5000,10001,15001},{7000,10001,17001},
                {9801,10001,1000},{9802,10001, 900},{9803,10001,10}};
        solution.getSkyline(buildings);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    public List<List<Integer>> getSkyline(int[][] buildings) {
//        List<List<Integer>> res = new ArrayList<>();
//        List<List<Integer>> heights = new ArrayList<>();
//        for (int[] b : buildings) {
//            heights.add(Arrays.asList(b[0], -b[2]));  // left corner
//            heights.add(Arrays.asList(b[1], b[2]));   // right corner
//        }
//        Collections.sort(heights, (a, b) -> {
//            if (a.get(0) != b.get(0)) {
//                return a.get(0) - b.get(0);   // x axis, ascending order
//            }
//            return a.get(1) - b.get(1);  // same x axis, heights ascending order
//        });
//
//        print2D(heights);
//
//        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));  // descending order
//        pq.offer(0);
//        int prev = 0;
//        for (List<Integer> h : heights) {
//            System.out.println("x="+h.get(0)+"; h="+h.get(1));
//            if (h.get(1) < 0) {   // if left point, insert height into queue
//                pq.offer(-h.get(1));
//            } else {              // if right point, remove height from queue
//                pq.remove(h.get(1));
//            }
//            int curr = pq.peek();
////            System.out.println(prev + "; " + curr);
////            System.out.println(prev != curr);
//
//            if (prev != curr) {
//                System.out.println(prev!=curr);
//                System.out.println("prev: " + prev + "; curr=" + curr + "; x=" + h.get(0) + "; h.get(1)=" + h.get(1));
//
//                res.add(Arrays.asList(h.get(0), curr));
//                prev = curr;
//            }
//        }
//        return res;
//    }
//    public void print2D(List<List<Integer>> input) {
//        for (int i = 0; i < input.size(); i++) {
//            System.out.println(i + ": " + input.get(i));
//        }
//    }
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        List<int[]> heights = new ArrayList<>();
        for (int[] b : buildings) {
            heights.add(new int[]{b[0], -b[2]});  // left corner
            heights.add(new int[]{b[1], b[2]});   // right corner
        }
        Collections.sort(heights, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];   // x axis, ascending order
            }
            return a[1] - b[1];  // same x axis, heights ascending order
            // (a.get(0) != b.get(0)) ? a.get(0) - b.get(0) : a.get(1) - b.get(1)
        });

        print2D(heights);

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));  // descending order
        pq.offer(0);
        int prev = 0;
        for (int[] h : heights) {
            if (h[1] < 0) {   // if left point, insert height into queue
                pq.offer(-h[1]);
            } else {              // if right point, remove height from queue
                pq.remove(h[1]);
            }
            int curr = pq.peek();
            if (prev != curr) {
                System.out.println("prev: " + prev + "; curr=" + curr + "; x=" + h[0] + "; h.get(1)=" + h[1]);

                res.add(Arrays.asList(h[0], curr));
                prev = curr;
            }
        }
        return res;
    }
    public void print2D(List<int[]> input) {
        for (int i = 0; i < input.size(); i++) {
            System.out.println(i + ": " + input.get(i)[0] + ", " + input.get(i)[1]);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}