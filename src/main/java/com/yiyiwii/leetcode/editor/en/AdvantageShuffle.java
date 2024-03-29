//Given two arrays A and B of equal size, the advantage of A with respect to B i
//s the number of indices i for which A[i] > B[i]. 
//
// Return any permutation of A that maximizes its advantage with respect to B. 
//
// 
//
// 
// Example 1: 
//
// 
//Input: A = [2,7,11,15], B = [1,10,4,11]
//Output: [2,11,7,15]
// 
//
// 
// Example 2: 
//
// 
//Input: A = [12,24,8,32], B = [13,25,32,11]
//Output: [24,32,8,12]
// 
//
// 
//
// Note: 
//
// 
// 1 <= A.length = B.length <= 10000 
// 0 <= A[i] <= 10^9 
// 0 <= B[i] <= 10^9 
// 
// 
// 
// Related Topics Array Greedy 
// 👍 608 👎 39


package com.yiyiwii.leetcode.editor.en;

import java.util.TreeMap;

public class AdvantageShuffle {
    public static void main(String[] args) {
        Solution solution = new AdvantageShuffle().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] advantageCount(int[] A, int[] B) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : A) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[] res = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            Integer x = map.higherKey(B[i]);
            if (x == null) {
                x = map.firstKey();
            }
            map.put(x, map.get(x) - 1);
            if (map.get(x) == 0) {
                map.remove(x);
            }
            res[i] = x;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}