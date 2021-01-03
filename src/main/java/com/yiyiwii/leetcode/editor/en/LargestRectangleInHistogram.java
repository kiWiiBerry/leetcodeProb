//Given n non-negative integers representing the histogram's bar height where th
//e width of each bar is 1, find the area of largest rectangle in the histogram. 
//
// 
//
// 
//Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3
//]. 
//
// 
//
// 
//The largest rectangle is shown in the shaded area, which has area = 10 unit. 
//
// 
//
// Example: 
//
// 
//Input: [2,1,5,6,2,3]
//Output: 10
// 
// Related Topics Array Stack 
// 👍 4988 👎 104


package com.yiyiwii.leetcode.editor.en;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        Solution solution = new LargestRectangleInHistogram().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i <= heights.length; i++) {
            while (!stack.isEmpty() && (i == heights.length || heights[stack.peek()] > heights[i])) {
                int prev = stack.pop();
                if (stack.isEmpty()) {
                    res = Math.max(res, heights[prev] * i);
                } else {
                    res = Math.max(res, heights[prev] * (i - stack.peek() - 1));
                }
            }
            stack.push(i);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}