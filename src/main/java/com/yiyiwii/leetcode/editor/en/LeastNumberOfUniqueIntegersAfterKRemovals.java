//Given an array of integers arr and an integer k. Find the least number of uniq
//ue integers after removing exactly k elements. 
//
// 
// 
//
// 
// Example 1: 
//
// 
//Input: arr = [5,5,4], k = 1
//Output: 1
//Explanation: Remove the single 4, only 5 is left.
// 
//Example 2:
//
// 
//Input: arr = [4,3,1,1,3,3,2], k = 3
//Output: 2
//Explanation: Remove 4, 2 and either one of the two 1s or three 3s. 1 and 3 wil
//l be left. 
//
// 
// Constraints: 
//
// 
// 1 <= arr.length <= 10^5 
// 1 <= arr[i] <= 10^9 
// 0 <= k <= arr.length 
// Related Topics Array Sort 
// 👍 398 👎 42


package com.yiyiwii.leetcode.editor.en;

import java.util.*;
import java.util.stream.Collectors;

public class LeastNumberOfUniqueIntegersAfterKRemovals {
    public static void main(String[] args) {
//        int[] arr = {5, 5, 4}; int k = 1;
        int[] arr = {2, 4,1,8,3,5,1,3}; int k = 3;

        Solution sol = new LeastNumberOfUniqueIntegersAfterKRemovals().new Solution();
        sol.findLeastNumOfUniqueInts(arr, k);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int num : arr) {
//            map.put(num, map.getOrDefault(num, 0) + 1);
//        }
////        Map<Integer, Integer> sorted = map.entrySet().stream()
////                .sorted(Map.Entry.comparingByValue())
////                .collect(Collectors.toMap(e -> e.getKey(), e-> e.getValue()));
//
////        for (Map.Entry<Integer, Integer> entry : sorted.entrySet()) {
////            System.out.println(entry.getKey() + ":" + entry.getValue().toString());
////        }
////        Map<Integer, Integer> sorted = map.entrySet().stream()
////                .sorted(Map.Entry.comparingByValue())
////                .collect(Collectors.toMap(e -> e.getKey(), e-> e.getValue()));
//
//        List<Integer> values = new ArrayList<>(map.values());
//        int count = 0;
//        for(int n : values) {
//            k -= n;
//
//            if (k < 0)
//                break;
//            else
//                count++;
//        }
//
//        int res = map.keySet().size() - count;
//        return k < 0 ? res + 1 : res;
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.stream(arr).forEach(e -> map.put(e, map.getOrDefault(e, 0) + 1));
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());
        int removals = 0, n = list.size();
        for (int i = 0; i < n && k > 0; i++) {
            k -= list.get(i).getValue();
            if (k >= 0) removals++;
        }
        return n - removals;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}