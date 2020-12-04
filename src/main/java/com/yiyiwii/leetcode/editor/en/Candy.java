//There are N children standing in a line. Each child is assigned a rating value
//. 
//
// You are giving candies to these children subjected to the following requireme
//nts: 
//
// 
// Each child must have at least one candy. 
// Children with a higher rating get more candies than their neighbors. 
// 
//
// What is the minimum candies you must give? 
//
// Example 1: 
//
// 
//Input: [1,0,2]
//Output: 5
//Explanation: You can allocate to the first, second and third child with 2, 1, 
//2 candies respectively.
// 
//
// Example 2: 
//
// 
//Input: [1,2,2]
//Output: 4
//Explanation: You can allocate to the first, second and third child with 1, 2, 
//1 candies respectively.
//             The third child gets 1 candy because it satisfies the above two c
//onditions.
//
// One Pass Solution: http://www.allenlipeng47.com/blog/index.php/2016/07/21/candy/
// 
// Related Topics Greedy 
// 👍 1200 👎 177


package com.yiyiwii.leetcode.editor.en;

import java.util.Arrays;

public class Candy {
    public static void main(String[] args) {
        Solution solution = new Candy().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int candy(int[] ratings) {
        int[] res = new int[ratings.length];
        Arrays.fill(res, 1);
        for (int i = 1; i < res.length; i++) {
            if (ratings[i] > ratings[i - 1])
                res[i] = res[i - 1] + 1;
        }
        for (int i = res.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && res[i] <= res[i + 1])
                res[i] = res[i + 1] + 1;
        }
        return Arrays.stream(res).sum();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}