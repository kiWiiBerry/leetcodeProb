//You have an inventory of different colored balls, and there is a customer that
// wants orders balls of any color. 
//
// The customer weirdly values the colored balls. Each colored ball's value is t
//he number of balls of that color you currently have in your inventory. For examp
//le, if you own 6 yellow balls, the customer would pay 6 for the first yellow bal
//l. After the transaction, there are only 5 yellow balls left, so the next yellow
// ball is then valued at 5 (i.e., the value of the balls decreases as you sell mo
//re to the customer). 
//
// You are given an integer array, inventory, where inventory[i] represents the 
//number of balls of the ith color that you initially own. You are also given an i
//nteger orders, which represents the total number of balls that the customer want
//s. You can sell the balls in any order. 
//
// Return the maximum total value that you can attain after selling orders color
//ed balls. As the answer may be too large, return it modulo 109 + 7. 
//
// 
// Example 1: 
//
// 
//Input: inventory = [2,5], orders = 4
//Output: 14
//Explanation: Sell the 1st color 1 time (2) and the 2nd color 3 times (5 + 4 + 
//3).
//The maximum total value is 2 + 5 + 4 + 3 = 14.
// 
//
// Example 2: 
//
// 
//Input: inventory = [3,5], orders = 6
//Output: 19
//Explanation: Sell the 1st color 2 times (3 + 2) and the 2nd color 4 times (5 +
// 4 + 3 + 2).
//The maximum total value is 3 + 2 + 5 + 4 + 3 + 2 = 19.
// 
//
// Example 3: 
//
// 
//Input: inventory = [2,8,4,10,6], orders = 20
//Output: 110
// 
//
// Example 4: 
//
// 
//Input: inventory = [1000000000], orders = 1000000000
//Output: 21
//Explanation: Sell the 1st color 1000000000 times for a total value of 50000000
//0500000000. 500000000500000000 modulo 109 + 7 = 21.
// 
//
// 
// Constraints: 
//
// 
// 1 <= inventory.length <= 105 
// 1 <= inventory[i] <= 109 
// 1 <= orders <= min(sum(inventory[i]), 109) 
// 
// Related Topics Math Greedy Sort 
// 👍 315 👎 83


package com.yiyiwii.leetcode.editor.en;

import java.util.*;
import java.util.stream.Collectors;

public class SellDiminishingValuedColoredBalls {
    public static void main(String[] args) {
        Solution sol = new SellDiminishingValuedColoredBalls().new Solution();
        sol.test(new int[]{6,4},4, 19);
        sol.test(new int[]{10,10},5, 46);
        sol.test(new int[]{3,5},6, 19);

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    class Item {
        long value;
        int cnt;
    }
    public void test(int[] inventory, int orders, int expected) {
        int res = maxProfit(inventory, orders);
        System.out.println("ACTUAL: " + res);
        System.out.println("EXPECTED: " + expected);
    }
    public int maxProfit(int[] inventory, int orders) {
        int mod = 1_000_000_007;
        Arrays.sort(inventory);
        int curIndex = inventory.length - 1;
        int curValue = inventory[curIndex];
        long profit = 0;
        while (orders > 0) {
            while (curIndex >= 0 && inventory[curIndex] == curValue) {
                curIndex--;
            }
            // if all colors of balls are the same value, nextValue is 0
            int nextValue = curIndex < 0 ? 0 : inventory[curIndex];
            // number of colors of balls with same value
            int numSameColor = inventory.length - 1 - curIndex;
            // number of items to buy
            int nums = (curValue - nextValue) * numSameColor;
            if (orders >= nums) {
                // buy all items
                profit += (long)(curValue + nextValue + 1) * (curValue - nextValue) / 2 * numSameColor;
            } else {
                // orders left is less than the number of items to buy
                int numFullRow = orders / numSameColor;
                int remainder = orders % numSameColor;
                profit += (long)(curValue + curValue - numFullRow + 1) * numFullRow / 2 * numSameColor;
                profit += (long)(curValue - numFullRow) * remainder;
            }
            orders -= nums;
            profit = profit % mod;
            curValue = nextValue;
        }
        return (int)profit;

//        TreeMap<Integer, Integer> map = new TreeMap<>();
//        for(int i = 0; i < inventory.length; i++) {
//            if(map.containsKey(inventory[i])) {
//                map.put(inventory[i], map.get(inventory[i]) + 1);
//            }else {
//                map.put(inventory[i], 1);
//            }
//        }
//        long profit = 0;
//        while(orders > 0) {
//            int FN = (int) map.lastKey();
//            int FC = map.get(FN);
//            map.remove(FN);
//            int SN = map.size() > 0 ? (int) map.lastKey() : 0;
//            int SC = map.size() > 0 ? map.get(SN) : 0;
//            int rows = FN - SN;
//            if(rows * FC >= orders) {
//                int complete = orders / FC;
//                int remainder = orders - complete * FC;
//                profit += FC * (long)((complete * (long)(FN - complete + 1 + FN)) / 2);
//                profit += (FN - complete) * (long)remainder;
//                return (int)(profit % mod);
//            }else {
//                profit += FC * (long)((rows * (long)(FN - rows + 1 + FN)) / 2);
//                orders -= rows * FC;
//                map.put(SN, FC + SC);
//            }
//        }
//        return (int)(profit % mod);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}