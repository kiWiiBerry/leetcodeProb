//In the "100 game" two players take turns adding, to a running total, any integ
//er from 1 to 10. The player who first causes the running total to reach or excee
//d 100 wins. 
//
// What if we change the game so that players cannot re-use integers? 
//
// For example, two players might take turns drawing from a common pool of numbe
//rs from 1 to 15 without replacement until they reach a total >= 100. 
//
// Given two integers maxChoosableInteger and desiredTotal, return true if the f
//irst player to move can force a win, otherwise return false. Assume both players
// play optimally. 
//
// 
// Example 1: 
//
// 
//Input: maxChoosableInteger = 10, desiredTotal = 11
//Output: false
//Explanation:
//No matter which integer the first player choose, the first player will lose.
//The first player can choose an integer from 1 up to 10.
//If the first player choose 1, the second player can only choose integers from 
//2 up to 10.
//The second player will win by choosing 10 and get a total = 11, which is >= de
//siredTotal.
//Same with other integers chosen by the first player, the second player will al
//ways win.
// 
//
// Example 2: 
//
// 
//Input: maxChoosableInteger = 10, desiredTotal = 0
//Output: true
// 
//
// Example 3: 
//
// 
//Input: maxChoosableInteger = 10, desiredTotal = 1
//Output: true
// 
//
// 
// Constraints: 
//
// 
// 1 <= maxChoosableInteger <= 20 
// 0 <= desiredTotal <= 300 
// 
// Related Topics Dynamic Programming Minimax 
// 👍 1140 👎 190


package com.yiyiwii.leetcode.editor.en;
public class CanIWin {
    public static void main(String[] args) {
        Solution solution = new CanIWin().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}