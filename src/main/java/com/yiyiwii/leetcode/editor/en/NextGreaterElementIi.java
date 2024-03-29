//
//Given a circular array (the next element of the last element is the first elem
//ent of the array), print the Next Greater Number for every element. The Next Gre
//ater Number of a number x is the first greater number to its traversing-order ne
//xt in the array, which means you could search circularly to find its next greate
//r number. If it doesn't exist, output -1 for this number.
// 
//
// Example 1: 
// 
//Input: [1,2,1]
//Output: [2,-1,2]
//Explanation: The first 1's next greater number is 2; The number 2 can't find n
//ext greater number; The second 1's next greater number needs to search circularl
//y, which is also 2.
// 
// 
//
// Note:
//The length of given array won't exceed 10000.
// Related Topics Stack 
// 👍 1939 👎 83


package com.yiyiwii.leetcode.editor.en;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class NextGreaterElementIi {
    public static void main(String[] args) {
        Solution solution = new NextGreaterElementIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < 2 * nums.length; i++) {
            while (!stack.isEmpty() && nums[i % nums.length] > nums[stack.peek()]) {
                res[stack.pop()] = nums[i % nums.length];
            }
            stack.push(i % nums.length);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}