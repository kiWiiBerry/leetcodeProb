//Given an array of intervals where intervals[i] = [starti, endi], merge all ove
//rlapping intervals, and return an array of the non-overlapping intervals that co
//ver all the intervals in the input. 
//
// 
// Example 1: 
//
// 
//Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
//Output: [[1,6],[8,10],[15,18]]
//Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
// 
//
// Example 2: 
//
// 
//Input: intervals = [[1,4],[4,5]]
//Output: [[1,5]]
//Explanation: Intervals [1,4] and [4,5] are considered overlapping.
// 
//
// 
// Constraints: 
//
// 
// 1 <= intervals.length <= 104 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 104 
// 
// Related Topics Array Sort 
// 👍 7432 👎 386


package com.yiyiwii.leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        Solution solution = new MergeIntervals().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;
        Arrays.sort(intervals, (a1, a2) -> a1[0] - a2[0]);
        List<int[]> res = new ArrayList<>();
        int[] newInterval = intervals[0];
        res.add(newInterval);

        for (int[] interval : intervals) {
            if (interval[0] <= newInterval[1]) {
                res.get(res.size() - 1)[1] = Math.max(interval[1], newInterval[1]);
            } else {
                newInterval = interval;
                res.add(newInterval);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}