//Given a string of numbers and operators, return all possible results from comp
//uting all the different possible ways to group numbers and operators. The valid 
//operators are +, - and *. 
//
// Example 1: 
//
// 
//Input: "2-1-1"
//Output: [0, 2]
//Explanation: 
//((2-1)-1) = 0 
//(2-(1-1)) = 2 
//
// Example 2: 
//
// 
//Input: "2*3-4*5"
//Output: [-34, -14, -10, -10, 10]
//Explanation: 
//(2*(3-(4*5))) = -34 
//((2*3)-(4*5)) = -14 
//((2*(3-4))*5) = -10 
//(2*((3-4)*5)) = -10 
//(((2*3)-4)*5) = 10
// Related Topics Divide and Conquer 
// 👍 1923 👎 101


package com.yiyiwii.leetcode.editor.en;

import java.util.List;

public class DifferentWaysToAddParentheses {
    public static void main(String[] args) {
        Solution solution = new DifferentWaysToAddParentheses().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}