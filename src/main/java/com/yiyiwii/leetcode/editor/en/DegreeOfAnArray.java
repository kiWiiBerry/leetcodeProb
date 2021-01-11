//Given a non-empty array of non-negative integers nums, the degree of this arra
//y is defined as the maximum frequency of any one of its elements. 
//
// Your task is to find the smallest possible length of a (contiguous) subarray 
//of nums, that has the same degree as nums. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,2,3,1]
//Output: 2
//Explanation: 
//The input array has a degree of 2 because both elements 1 and 2 appear twice.
//Of the subarrays that have the same degree:
//[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
//The shortest length is 2. So return 2.
// 
//
// Example 2: 
//
// 
//Input: nums = [1,2,2,3,1,4,2]
//Output: 6
//Explanation: 
//The degree is 3 because the element 2 is repeated 3 times.
//So [2,2,3,1,4,2] is the shortest subarray, therefore returning 6.
// 
//
// 
// Constraints: 
//
// 
// nums.length will be between 1 and 50,000. 
// nums[i] will be an integer between 0 and 49,999. 
// 
// Related Topics Array 
// 👍 1091 👎 864


package com.yiyiwii.leetcode.editor.en;

import java.util.Collections;
import java.util.HashMap;

public class DegreeOfAnArray {
    public static void main(String[] args) {
        Solution solution = new DegreeOfAnArray().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // Method One-pass
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> first = new HashMap<>(),
                counts = new HashMap<>();
        int degree = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            first.putIfAbsent(x, i);
            counts.put(x, counts.getOrDefault(x, 0) + 1);
            if (counts.get(x) > degree) {
                degree = counts.get(x);
                res = i - first.get(x) + 1;
            } else if (counts.get(x) == degree) {
                res = Math.min(res, i - first.get(x) + 1);
            }
        }

        return res;
    }
//    public int findShortestSubArray(int[] nums) {
//        HashMap<Integer, Integer> left = new HashMap<>(),
//                right = new HashMap<>(), counts = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            int x = nums[i];
//            left.putIfAbsent(x, i);
//            right.put(x, i);
//            counts.put(x, counts.getOrDefault(x, 0) + 1);
//        }
//        int res = nums.length;
//        int degree = Collections.max(counts.values());
//        for (int key : counts.keySet()) {
//            if (counts.get(key) == degree) {
//                res = Math.min(res, right.get(key) - left.get(key) + 1);
//            }
//        }
//        return res;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

}