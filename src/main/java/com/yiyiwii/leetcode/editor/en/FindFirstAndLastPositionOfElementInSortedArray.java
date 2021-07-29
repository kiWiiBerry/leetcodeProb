//Given an array of integers nums sorted in ascending order, find the starting a
//nd ending position of a given target value. 
//
// If target is not found in the array, return [-1, -1]. 
//
// Follow up: Could you write an algorithm with O(log n) runtime complexity? 
//
// 
// Example 1: 
// Input: nums = [5,7,7,8,8,10], target = 8
//Output: [3,4]
// Example 2: 
// Input: nums = [5,7,7,8,8,10], target = 6
//Output: [-1,-1]
// Example 3: 
// Input: nums = [], target = 0
//Output: [-1,-1]
// 
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// nums is a non-decreasing array. 
// -109 <= target <= 109 
// 
// Related Topics Array Binary Search 
// 👍 4529 👎 179


package com.yiyiwii.leetcode.editor.en;
public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        solution.searchRange(nums, target);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1,-1};
        }
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(nums[left] + ", " + nums[right]);
//        int last = left;
//        if (nums[left] != target) {
            return new int[]{-1,-1};
//        }
//        int first = last;
//        while (first - 1 >= 0 && nums[first] == nums[first - 1]) {
//            first--;
//        }
//        return new int[]{first, last};

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}