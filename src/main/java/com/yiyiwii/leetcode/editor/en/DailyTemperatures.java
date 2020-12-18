//
//Given a list of daily temperatures T, return a list such that, for each day in
// the input, tells you how many days you would have to wait until a warmer temper
//ature. If there is no future day for which this is possible, put 0 instead.
// 
//For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 7
//3], your output should be [1, 1, 4, 2, 1, 1, 0, 0].
// 
//
// Note:
//The length of temperatures will be in the range [1, 30000].
//Each temperature will be an integer in the range [30, 100].
// Related Topics Hash Table Stack 
// 👍 3520 👎 109


package com.yiyiwii.leetcode.editor.en;

import java.util.Stack;

public class DailyTemperatures {
    public static void main(String[] args) {
        Solution solution = new DailyTemperatures().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack();
        int[] res = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int inx = stack.pop();
                res[inx] = i - inx;
            }
            stack.push(i);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}