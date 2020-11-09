// Days of the week are represented as ("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")
// Given a string representing the day of the week and an integer K,
// return the day of the week that is K days later.
//
// Example, given S="Wed", K = 2, return "Fri"
// Example 2, given S="Sat", K = 23, return "Mon"

package com.yiyiwii.leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MsDayOfWeekKDaysLater {
    public static void main(String[] args) {
        Solution solution = new MsDayOfWeekKDaysLater().new Solution();
        String day = "Wed";
        int K = 3;
        String res = solution.dayOfWeekWithK(day, K);

        System.out.println(res);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String dayOfWeekWithK(String day, int K) {
            List<String> days = new ArrayList<String>(Arrays.asList("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"));
            return days.get((days.indexOf(day) + K) % 7);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}