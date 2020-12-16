//Given n pairs of parentheses, write a function to generate all combinations of
// well-formed parentheses. 
//
// 
// Example 1: 
// Input: n = 3
//Output: ["((()))","(()())","(())()","()(())","()()()"]
// Example 2: 
// Input: n = 1
//Output: ["()"]
// 
// 
// Constraints: 
//
// 
// 1 <= n <= 8 
// 
// Related Topics String Backtracking 
// 👍 6612 👎 301


package com.yiyiwii.leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(res, "", 0, 0, n);
        return res;
    }
    public void helper(List<String> res, String curr,
                       int numClose, int numOpen, int n) {
        if (curr.length() == n * 2) {
            res.add(curr);
            return;
        }
        if (numOpen < n) {
            helper(res, curr + "(", numClose, numOpen + 1, n);
        }
        if (numClose < numOpen) {
            helper(res, curr + ")", numClose + 1, numOpen, n);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}