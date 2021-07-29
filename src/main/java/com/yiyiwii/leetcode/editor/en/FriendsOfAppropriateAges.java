//There are n persons on a social media website. You are given an integer array 
//ages where ages[i] is the age of the ith person. 
//
// A Person x will not send a friend request to a person y (x != y) if any of th
//e following conditions is true: 
//
// 
// age[y] <= 0.5 * age[x] + 7 
// age[y] > age[x] 
// age[y] > 100 && age[x] < 100 
// 
//
// Otherwise, x will send a friend request to y. 
//
// Note that if x sends a request to y, y will not necessarily send a request to
// x. Also, a person will not send a friend request to themself. 
//
// Return the total number of friend requests made. 
//
// 
// Example 1: 
//
// 
//Input: ages = [16,16]
//Output: 2
//Explanation: 2 people friend request each other.
// 
//
// Example 2: 
//
// 
//Input: ages = [16,17,18]
//Output: 2
//Explanation: Friend requests are made 17 -> 16, 18 -> 17.
// 
//
// Example 3: 
//
// 
//Input: ages = [20,30,100,110,120]
//Output: 3
//Explanation: Friend requests are made 110 -> 100, 120 -> 110, 120 -> 100.
// 
//
// 
// Constraints: 
//
// 
// n == ages.length 
// 1 <= n <= 2 * 104 
// 1 <= ages[i] <= 120 
// 
// Related Topics Array Two Pointers Binary Search Sorting 
// 👍 434 👎 875


package com.yiyiwii.leetcode.editor.en;
public class FriendsOfAppropriateAges {
    public static void main(String[] args) {
        Solution solution = new FriendsOfAppropriateAges().new Solution();
        int[] ages = {30, 48, 56, 69, 101};
        solution.numFriendRequests(ages);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numFriendRequests(int[] ages) {
        int res = 0;
        for (int i = ages.length - 1; i >= 1; i--) {
            System.out.println("age: " + ages[i] + "--------");
            System.out.println( ages[i] / 2 + 8);
            int lower = lowerBound(ages, 0, i - 1, ages[i] / 2 + 8);
            int upper = upperbound(ages, 0, i - 1, ages[i]);
            if (ages[upper] < ages[i] / 2 + 8) {
                continue;
            } else {
                res += (upper - lower + 1);
            }
            System.out.println("lowerB: " + ages[lower] + "; idx = " + lower);
            System.out.println("upperB: " + ages[upper] + "; idx = " + upper);
            System.out.println("num: " + (upper - lower + 1));
        }

//        int i = ages.length - 1;
//        int lower = lowerBound(ages, 0, i - 1, ages[i] / 2 + 8);
        System.out.println("finalRes: " + res);
        return res;
    }
    public int lowerBound(int[] ages, int left, int right, int target) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (target <= ages[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    public int upperbound(int[] ages, int left, int right, int target) {
        while (left < right) {
            int mid = left + (right - left) / 2 + 1;

            if (target >= ages[mid]) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}