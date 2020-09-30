//Given a collection of numbers that might contain duplicates, return all possib
//le unique permutations. 
//
// Example: 
//
// 
//Input: [1,1,2]
//Output:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//]
// 
// Related Topics Backtracking 
// 👍 1991 👎 61

  
package com.yiyiwii.leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsIi {
    public static void main(String[] args) {
        Solution solution = new PermutationsIi().new Solution();
        int[] test = {1,1,2};
        solution.permuteUnique(test);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums==null || nums.length==0) return res;

        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];

        backtrack(res, new ArrayList<>(), nums, used);
        return res;
    }

    private void backtrack(List<List<Integer>> res,
                           List<Integer> list, int[] nums,
                           boolean[] used) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
        }
        System.out.println(used);
        System.out.println(used.length);
        for (int i = 0; i < nums.length; i++) {

            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                continue;
            used[i] = true;
            list.add(nums[i]);
            backtrack(res, list, nums, used);
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}