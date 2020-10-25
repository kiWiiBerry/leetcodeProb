//Given an array of n integers nums, a 132 pattern is a subsequence of three int
//egers nums[i], nums[j] and nums[k] such that i < j < k and nums[i] < nums[k] < n
//ums[j]. 
//
// Return true if there is a 132 pattern in nums, otherwise, return false. 
//
// Follow up: The O(n^2) is trivial, could you come up with the O(n logn) or the
// O(n) solution? 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3,4]
//Output: false
//Explanation: There is no 132 pattern in the sequence.
// 
//
// Example 2: 
//
// 
//Input: nums = [3,1,4,2]
//Output: true
//Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
// 
//
// Example 3: 
//
// 
//Input: nums = [-1,3,2,0]
//Output: true
//Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3,
// 0] and [-1, 2, 0].
// 
//
// 
// Constraints: 
//
// 
// n == nums.length 
// 1 <= n <= 104 
// -109 <= nums[i] <= 109 
// 
// Related Topics Stack 
// 👍 1907 👎 121


package com.yiyiwii.leetcode.editor.en;

import java.util.Stack;

public class One32Pattern {
    public static void main(String[] args) {
        Solution solution = new One32Pattern().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> stack = new Stack();
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= min) {
                min = num;
            } else {
                while (!stack.isEmpty()) {
                    if (stack.peek() >= num) break;
                    stack.pop();
                    if (stack.pop() > num) return true;
                }
                stack.push(num);
                stack.push(min);
            }
        }
        return false;
        // Method 1, brute force, time exceeded
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                for (int k = j + 1; k < nums.length; k++) {
//                    if (nums[i] < nums[k] && nums[k] < nums[j])
//                        return true;
//                }
//            }
//        }
//        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}