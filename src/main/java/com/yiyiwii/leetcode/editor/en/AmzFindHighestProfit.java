/**
 * Amazon Basics has several supplies for its products. For each of the products, the stock is represeted by a list of a number pf otems for each supplier. As items are purchased, the supplier raises the price by 1 per item purchased. Let's assume Amazon's profit on any single item is the same as the number of items the supplier has left. For example, if a supplier has 4 items, Amazon's profit on the first item sold is 4, then 3, then 2 and the profit of the last one is 1.
 *
 * Given a list where each value in the list is the number of the item at a given supplier and also given the number of items to be ordered, write an algorithm to find the highest profit that can be generated for the given product.
 *
 * Input
 * The input to the function's method consists of these arguments:
 * numSuppliers, and integer representing the number of suppliers;
 * inventory, a list of long integers representing the value of the item at a given supplier;
 * order, a long integer representing the number of items to be ordered
 *
 * Output
 * Return a long integer representing the highest profit that can be generated for the given product.
 *
 * Constraints
 * 1 <= numSuppliers <= 10^5
 * 1 <= inventory[i] <= 10^5
 * 0 <= i <= numSuppliers
 * 1 <= order <= Sum of inventory
 *
 * Example
 * Input:
 * numSuppliers = 2
 * inventory = [3,5]
 * order = 6
 * */
package com.yiyiwii.leetcode.editor.en;

import java.util.Arrays;
import java.util.List;

public class AmzFindHighestProfit {
    int mod = 1_000_000_007;
    public static void main(String[] args) {
        SellDiminishingValuedColoredBalls.Solution solution = new SellDiminishingValuedColoredBalls().new Solution();
    }
    class Solution {
        public int findProfit(int[] inventory, int orders) {
            int mod = 1_000_000_007;
            Arrays.sort(inventory);
            int curIdx = inventory.length - 1;
            int curStock = inventory[curIdx];
            long profit = 0;
            while (orders > 0) {
                while (curIdx >= 0 && inventory[curIdx] == curStock) {
                    curIdx--;
                }
                // if all colors of balls are the same value, nextValue is 0
                int nextStock = curIdx < 0 ? 0 : inventory[curIdx];
                // number of colors of balls with same value
                int numSameStock = inventory.length - 1 - curIdx;
                // number of items to buy
                int nums = (curStock - nextStock) * numSameStock;
                if (orders >= nums) {
                    // buy all items
                    profit += (long)(curStock + nextStock + 1) * (curStock - nextStock) / 2 * numSameStock;
                } else {
                    // orders left is less than the number of items to buy
                    int numFullRow = orders / numSameStock;
                    int remainder = orders % numSameStock;
                    profit += (long)(curStock + curStock - numFullRow + 1) * numFullRow / 2 * numSameStock;
                    profit += (long)(curStock - numFullRow) * remainder;
                }
                orders -= nums;
                profit = profit % mod;
                curStock = nextStock;
            }
            return (int)profit;
        }
    }
}
