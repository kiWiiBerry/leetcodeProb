//Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elemen
//ts appear twice and others appear once. 
//
// Find all the elements of [1, n] inclusive that do not appear in this array. 
//
// Could you do it without extra space and in O(n) runtime? You may assume the r
//eturned list does not count as extra space. 
//
// Example:
// 
//Input:
//[4,3,2,7,8,2,3,1]
//
//Output:
//[5,6]
// 
// Related Topics Array 
// 👍 3540 👎 271


package com.yiyiwii.leetcode.editor.en;

import java.util.*;
import java.util.stream.Collectors;

public class FindAllNumbersDisappearedInAnArray {
    public static void main(String[] args) {
        Solution solution = new FindAllNumbersDisappearedInAnArray().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // Method 2, Set
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(i + 1)){
                res.add(i + 1);
            }
        }
        return res;
    }
//    // Method 1, in-place
//    public List<Integer> findDisappearedNumbers(int[] nums) {
//        List<Integer> res = new ArrayList<>();
//        for (int num : nums){
//            int pos = Math.abs(num) - 1;
//            if (nums[pos] > 0) {
//                nums[pos] = -nums[pos];
//            }
//        }
//        for (int i = 0; i < nums.length; i++){
//            if (nums[i] > 0) {
//                res.add(i + 1);
//            }
//        }
//        return res;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

}