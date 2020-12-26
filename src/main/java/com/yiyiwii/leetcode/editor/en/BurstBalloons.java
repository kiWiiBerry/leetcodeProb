//Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number
// on it represented by array nums. You are asked to burst all the balloons. If th
//e you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Her
//e left and right are adjacent indices of i. After the burst, the left and right 
//then becomes adjacent. 
//
// Find the maximum coins you can collect by bursting the balloons wisely. 
//
// Note: 
//
// 
// You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can n
//ot burst them. 
// 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100 
// 
//
// Example: 
//
// 
//Input: [3,1,5,8]
//Output: 167 
//Explanation: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
//             coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
// Related Topics Divide and Conquer Dynamic Programming 
// 👍 2937 👎 77


package com.yiyiwii.leetcode.editor.en;
public class BurstBalloons {
    public static void main(String[] args) {
        Solution solution = new BurstBalloons().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxCoins(int[] nums) {
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}