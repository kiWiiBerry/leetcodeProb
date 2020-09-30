//Given a set of distinct integers, nums, return all possible subsets (the power set). 
//
// Note: The solution set must not contain duplicate subsets. 
//
// Example: 
//
// 
//Input: nums = [1,2,3]
//Output:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//] 
// Related Topics Array Backtracking Bit Manipulation
  
package com.yiyiwii.leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

public class Subsets{
    public static void main(String[] args) {
        Solution solution = new Subsets().new Solution();
        int[] test = {1, 2, 3};
        solution.subsets(test);
    }
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> res = new ArrayList<>();
//        res.add(new ArrayList<>());
//
//        for (int i = 0; i < nums.length; i++) {
//            int size = res.size();
//            for (int j = 0; j < size; j++) {
////                System.out.println("res: " + res);
//                res.add(new ArrayList<>(res.get(j)));
//                res.get(res.size() - 1).add(nums[i]);
//            }
//        }
//
//        return res;
//    }
//    public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> res = new ArrayList<>();
//        List<Integer> list = new ArrayList<>();
//
//        if (nums == null || nums.length == 0) return res;
//
//        backtrack(nums, 0, list, res);
//
//        return res;
//    }
//
//    private void backtrack(int[] nums, int currInx,
//                           List<Integer> list, List<List<Integer>> res) {
//        if (currInx == nums.length) {
//            res.add(new ArrayList<>(list));
//
//        } else {
//            backtrack(nums, currInx + 1, list, res);
//            list.add(nums[currInx]);
//            backtrack(nums, currInx + 1, list, res);
//            list.remove(list.size() - 1);
//        }
//    }


//Solution 1: (Huahua)
//    public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> res = new ArrayList<>();
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i <= nums.length; i++) {
//            backtrack(nums, i, 0, list, res);
//        }
//
//        return res;
//    }
//
//    private void backtrack(int[] nums, int n, int s,
//                           List<Integer> list, List<List<Integer>> res) {
//        if (n == list.size()) {
//            res.add(new ArrayList<>(list));
//            return;
//        }
//
//        for (int i = s; i < nums.length; i++) {
//            list.add(nums[i]);
//            backtrack(nums, n, i + 1, list, res);
//            list.remove(list.size() - 1);
//        }
//    }

//Solution 2:
//    public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> res = new ArrayList<>();
//        res.add(new ArrayList<>());
//
//        for (int i = 0; i < nums.length; i++) {
//        int size = res.size();
//        for (int j = 0; j < size; j++) {
//        res.add(new ArrayList<>(res.get(j)));
//        res.get(res.size() - 1).add(nums[i]);
//        }
//        }
//
//        return res;
//    }

//Solution 3:
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        if (nums == null || nums.length == 0) return res;

        backtrack(nums, 0, list, res);

        return res;
    }

    private void backtrack(int[] nums, int currInx,
        List<Integer> list, List<List<Integer>> res) {

//        if ( i > currtdx && nums[ i ] == nums [i - 1]) return;
        if (currInx == nums.length) {
            res.add(new ArrayList<>(list));
        } else {
            backtrack(nums, currInx + 1, list, res);
            list.add(nums[currInx]);
            backtrack(nums, currInx + 1, list, res);
            list.remove(list.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
}
