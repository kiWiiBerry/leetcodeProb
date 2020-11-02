//Given an unsorted array of integers nums, return the length of the longest con
//secutive elements sequence. 
//
// Follow up: Could you implement the O(n) solution? 
//
// 
// Example 1: 
//
// 
//Input: nums = [100,4,200,1,3,2]
//Output: 4
//Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Theref
//ore its length is 4.
// 
//
// Example 2: 
//
// 
//Input: nums = [0,3,7,2,5,8,4,6,0,1]
//Output: 9
// 
//
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 104 
// -109 <= nums[i] <= 109 
// 
// Related Topics Array Union Find 
// 👍 4158 👎 207


package com.yiyiwii.leetcode.editor.en;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        Solution solution = new LongestConsecutiveSequence().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestConsecutive(int[] nums) {
        int max = 0;
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int cnt = 1;
                int currNum = num;
                while (set.contains(currNum + 1)) {
                    cnt++;
                    currNum++;
                }
                max = Math.max(cnt, max);
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}