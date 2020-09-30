//Given a string s, partition s such that every substring of the partition is a 
//palindrome. 
//
// Return all possible palindrome partitioning of s. 
//
// Example: 
//
// 
//Input: "aab"
//Output:
//[
//  ["aa","b"],
//  ["a","a","b"]
//]
// 
// Related Topics Backtracking 
// 👍 1957 👎 69

  
package com.yiyiwii.leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        Solution solution = new PalindromePartitioning().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), s, 0);
        return res;
    }

    private void backtrack(List<List<String>> res, List<String> tmpList,
                           String s, int start) {
        if (start == s.length()) {
            res.add(new ArrayList<String>(tmpList));
        } else {
            for (int i = start; i < s.length(); i++) {
                if (isPalindrome(s, start, i)) {
                    tmpList.add(s.substring(start, i + 1));
                    backtrack(res, tmpList, s, i + 1);
                    tmpList.remove(tmpList.size() - 1);
                }
            }
        }
    }

    private boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low++) != s.charAt(high--)){
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}