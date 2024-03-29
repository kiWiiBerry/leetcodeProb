//You are given a rectangular cake of size h x w and two arrays of integers hori
//zontalCuts and verticalCuts where: 
//
// 
// horizontalCuts[i] is the distance from the top of the rectangular cake to the
// ith horizontal cut and similarly, and 
// verticalCuts[j] is the distance from the left of the rectangular cake to the 
//jth vertical cut. 
// 
//
// Return the maximum area of a piece of cake after you cut at each horizontal a
//nd vertical position provided in the arrays horizontalCuts and verticalCuts. Sin
//ce the answer can be a large number, return this modulo 109 + 7. 
//
// 
// Example 1: 
//
// 
//Input: h = 5, w = 4, horizontalCuts = [1,2,4], verticalCuts = [1,3]
//Output: 4 
//Explanation: The figure above represents the given rectangular cake. Red lines
// are the horizontal and vertical cuts. After you cut the cake, the green piece o
//f cake has the maximum area.
// 
//
// Example 2: 
//
// 
//Input: h = 5, w = 4, horizontalCuts = [3,1], verticalCuts = [1]
//Output: 6
//Explanation: The figure above represents the given rectangular cake. Red lines
// are the horizontal and vertical cuts. After you cut the cake, the green and yel
//low pieces of cake have the maximum area.
// 
//
// Example 3: 
//
// 
//Input: h = 5, w = 4, horizontalCuts = [3], verticalCuts = [3]
//Output: 9
// 
//
// 
// Constraints: 
//
// 
// 2 <= h, w <= 109 
// 1 <= horizontalCuts.length <= min(h - 1, 105) 
// 1 <= verticalCuts.length <= min(w - 1, 105) 
// 1 <= horizontalCuts[i] < h 
// 1 <= verticalCuts[i] < w 
// All the elements in horizontalCuts are distinct. 
// All the elements in verticalCuts are distinct. 
// 
// Related Topics Array 
// 👍 661 👎 169


package com.yiyiwii.leetcode.editor.en;

import java.util.Arrays;

public class MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts {
    public static void main(String[] args) {
        Solution solution = new MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        long maxH = horizontalCuts[0];
        long maxV = verticalCuts[0];

        for (int i = 1; i < horizontalCuts.length; i++) {
            maxH = Math.max(maxH, horizontalCuts[i] - horizontalCuts[i - 1]);
        }
        maxH = Math.max(maxH, h - horizontalCuts[horizontalCuts.length - 1]);

        for (int i = 1; i < verticalCuts.length; i++) {
            maxV = Math.max(maxV, verticalCuts[i] - verticalCuts[i - 1]);
        }
        maxV = Math.max(maxV, w - verticalCuts[verticalCuts.length - 1]);

        return (int)((maxH * maxV) % (1_000_000_007));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}