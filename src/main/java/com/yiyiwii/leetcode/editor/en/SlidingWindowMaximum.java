//You are given an array of integers nums, there is a sliding window of size k w
//hich is moving from the very left of the array to the very right. You can only s
//ee the k numbers in the window. Each time the sliding window moves right by one 
//position. 
//
// Return the max sliding window. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
//Output: [3,3,5,5,6,7]
//Explanation: 
//Window position                Max
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// Example 2: 
//
// 
//Input: nums = [1], k = 1
//Output: [1]
// 
//
// Example 3: 
//
// 
//Input: nums = [1,-1], k = 1
//Output: [1,-1]
// 
//
// Example 4: 
//
// 
//Input: nums = [9,11], k = 2
//Output: [11]
// 
//
// Example 5: 
//
// 
//Input: nums = [4,-2], k = 2
//Output: [4]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 105 
// -104 <= nums[i] <= 104 
// 1 <= k <= nums.length 
// 
// Related Topics Heap Sliding Window 
// 👍 4436 👎 196


package com.yiyiwii.leetcode.editor.en;

import java.util.Collections;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        Solution solution = new SlidingWindowMaximum().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        return null;
    }
//    // Time Limit Exceeded
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        if (nums.length == 0) return new int[0];
//        int[] res = new int[nums.length - k + 1];
//        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
//
//        for (int i = 0; i < k; i++) {
//            queue.add(nums[i]);
//        }
//        res[0] = queue.peek();
//        for (int i = k; i < nums.length; i++) {
//            queue.remove(nums[i - k]);
//            queue.add(nums[i]);
//            res[i - k + 1] = queue.peek();
//        }
//        return res;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

}