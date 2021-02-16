//Given a string S, we can transform every letter individually to be lowercase o
//r uppercase to create another string. 
//
// Return a list of all possible strings we could create. You can return the out
//put in any order. 
//
// 
// Example 1: 
//
// 
//Input: S = "a1b2"
//Output: ["a1b2","a1B2","A1b2","A1B2"]
// 
//
// Example 2: 
//
// 
//Input: S = "3z4"
//Output: ["3z4","3Z4"]
// 
//
// Example 3: 
//
// 
//Input: S = "12345"
//Output: ["12345"]
// 
//
// Example 4: 
//
// 
//Input: S = "0"
//Output: ["0"]
// 
//
// 
// Constraints: 
//
// 
// S will be a string with length between 1 and 12. 
// S will consist only of letters or digits. 
// 
// Related Topics Backtracking Bit Manipulation 
// 👍 1750 👎 117


package com.yiyiwii.leetcode.editor.en;

import java.util.LinkedList;
import java.util.List;

public class LetterCasePermutation {
    public static void main(String[] args) {
        Solution solution = new LetterCasePermutation().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> letterCasePermutation(String S) {
        LinkedList<String> ans = new LinkedList<>();
        ans.add("");

        for (int i = 0; i < S.length(); i++) {
            int size = ans.size();
            for (int cnt = 0; cnt < size; cnt++) {
                String combi = ans.remove();
                char c = S.charAt(i);
                if (Character.isAlphabetic(c)) {
                    ans.add(combi + Character.toUpperCase(c));
                    ans.add(combi + Character.toLowerCase(c));
                } else {
                    ans.add(combi + c);
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}