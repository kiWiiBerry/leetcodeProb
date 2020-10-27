//Given an array of integers and an integer k, you need to find the total number
// of continuous subarrays whose sum equals to k. 
//
// Example 1: 
//
// 
//Input:nums = [1,1,1], k = 2
//Output: 2
// 
//
// 
// Constraints: 
//
// 
// The length of the array is in range [1, 20,000]. 
// The range of numbers in the array is [-1000, 1000] and the range of the integ
//er k is [-1e7, 1e7]. 
// 
// Related Topics Array Hash Table 
// 👍 5617 👎 183

  
package com.yiyiwii.leetcode.editor.en;

import java.util.HashMap;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        Solution solution = new SubarraySumEqualsK().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // Method 2, O(n)
    public int subarraySum(int[] nums, int k) {
        int sum = 0, res = 0;
        HashMap<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        for (int num: nums) {
            sum += num;
            res += preSum.getOrDefault(sum - k, 0);
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
//    // Method 1, O(n^2)
//    public int subarraySum(int[] nums, int k) {
//        int cnt = 0;
//        int[] sum = new int[nums.length + 1];
//        for (int i = 1; i < sum.length; i++) {
//            sum[i] = sum[i - 1] + nums[i - 1];
//        }
//        for (int start = 0; start < nums.length; start++) {
//            for (int end = start + 1; end <= nums.length; end++) {
//                if (sum[end] - sum[start] == k)
//                    cnt++;
//            }
//        }
//        return cnt;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

}