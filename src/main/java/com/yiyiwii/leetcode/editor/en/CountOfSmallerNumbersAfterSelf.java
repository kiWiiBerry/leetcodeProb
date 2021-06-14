//You are given an integer array nums and you have to return a new counts array.
// The counts array has the property where counts[i] is the number of smaller elem
//ents to the right of nums[i]. 
//
// 
// Example 1: 
//
// 
//Input: nums = [5,2,6,1]
//Output: [2,1,1,0]
//Explanation:
//To the right of 5 there are 2 smaller elements (2 and 1).
//To the right of 2 there is only 1 smaller element (1).
//To the right of 6 there is 1 smaller element (1).
//To the right of 1 there is 0 smaller element.
// 
//
// Example 2: 
//
// 
//Input: nums = [-1]
//Output: [0]
// 
//
// Example 3: 
//
// 
//Input: nums = [-1,-1]
//Output: [0,0]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 105 
// -104 <= nums[i] <= 104 
// 
// Related Topics Binary Search Divide and Conquer Sort Binary Indexed Tree Segm
//ent Tree 
// 👍 3658 👎 115


package com.yiyiwii.leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

public class CountOfSmallerNumbersAfterSelf {
    public static void main(String[] args) {
        Solution solution = new CountOfSmallerNumbersAfterSelf().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[] count;
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        int n = nums.length;
        count = new int[n];
        int[] indices = new int[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        mergSort(nums, indices, new int[n], 0, n - 1);
        for (int i = 0; i < n; i ++) {
            result.add(count[i]);
        }
        return result;
    }
    private void mergSort(int[] nums, int[] indices, int[] tmp, int start, int end){
        if (start >= end) return;
        int mid = start + (end - start) / 2;
        mergSort(nums, indices, tmp, start, mid);
        mergSort(nums, indices, tmp, mid + 1, end);
        merge(nums, indices, tmp, start, mid, end);
    }

        private void merge(int[] nums, int[] indices, int[] tmp, int start, int mid, int end){
            int left = start, right = mid + 1;
            int rCnt = 0;
            for (int i = start; i <= end; i++) {
                tmp[i] = indices[i];
            }
            for (int i = start; i <= end; i++) {
                if (left > mid) {
                    // All items in left array are in sorted array
                    indices[i] = tmp[right++];
                } else if (right > end) {
                    // All items in right array are in sorted array,
                    // they are smaller than left array, need to swap
                    indices[i] = tmp[left];
                    count[tmp[left++]] += rCnt;
                } else if (nums[tmp[right]] < nums[tmp[left]]) {
                    // item in right smaller than item in left, need to swap
                    indices[i] = tmp[right++];
                    rCnt++;
                } else {
                    // item in left smaller than item in right
                    indices[i] = tmp[left];
                    count[tmp[left++]] += rCnt;
                }
            }
        }

//    private void merge(int[] nums, int[] indices, int[] tmp, int start, int mid, int end){
//        int left = start, right = mid + 1;
//        int rCnt = 0;
//        for (int i = start; i <= end; i++) {
//            tmp[i] = indices[i];
//        }
//        for (int i = start; i <= end; i++) {
//            if (left > mid) {
//                // All items in left array are in sorted array
//                indices[i] = tmp[right++];
//            } else if (right > end) {
//                // All items in right array are in sorted array,
//                // they are smaller than left array, need to swap
//                indices[i] = tmp[left];
//                count[tmp[left++]] += rCnt;
//            } else if (nums[tmp[right]] < nums[tmp[left]]) {
//                // item in right smaller than item in left, need to swap
//                indices[i] = tmp[right++];
//                rCnt++;
//            } else {
//                // item in left smaller than item in right
//                indices[i] = tmp[left];
//                count[tmp[left++]] += rCnt;
//            }
//        }
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

}