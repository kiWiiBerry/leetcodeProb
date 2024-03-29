//You are a professional robber planning to rob houses along a street. Each hous
//e has a certain amount of money stashed, the only constraint stopping you from r
//obbing each of them is that adjacent houses have security system connected and i
//t will automatically contact the police if two adjacent houses were broken into 
//on the same night. 
//
// Given a list of non-negative integers representing the amount of money of eac
//h house, determine the maximum amount of money you can rob tonight without alert
//ing the police. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3,1]
//Output: 4
//Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
//             Total amount you can rob = 1 + 3 = 4.
// 
//
// Example 2: 
//
// 
//Input: nums = [2,7,9,3,1]
//Output: 12
//Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 
//(money = 1).
//             Total amount you can rob = 2 + 9 + 1 = 12.
// 
//
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 100 
// 0 <= nums[i] <= 400 
// 
// Related Topics Dynamic Programming 
// 👍 5675 👎 167

  
package com.yiyiwii.leetcode.editor.en;

import java.util.Arrays;

public class HouseRobber {
    public static void main(String[] args) {
        Solution solution = new HouseRobber().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int rob(int[] nums) {
        int rob = 0;
        int notRob = 0;
        for (int num : nums) {
            int pre = Math.max(rob, notRob);
            rob = num + notRob;
            notRob = pre;
        }
        return Math.max(rob, notRob);
        // Method 1
//        if (nums.length == 0) return 0;
//        if (nums.length <= 2) return Arrays.stream(nums).max().getAsInt();
//
//        int[] dp = new int[nums.length + 1];
//        dp[0] = 0;
//        dp[1] = nums[0];
//        for (int i = 2; i < dp.length; i++) {
//            dp[i] = Math.max(dp[i - 1], nums[i - 1] + dp[i - 2]);
//        }
//        return dp[nums.length];
    }
}
// Solution 1
//class Solution {
//    private int[] memo;
//    public int rob(int[] nums) {
//        memo = new int[nums.length];
//        Arrays.fill(memo, -1);
//        return dp(nums, 0);
//    }
//    public int dp(int[] nums, int start) {
//        if (start >= nums.length) return 0;
//        if (memo[start] != -1) return memo[start];
//        int res = Math.max(dp(nums, start + 1), nums[start] + dp(nums, start + 2));
//        memo[start] = res;
//        return res;
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)

}