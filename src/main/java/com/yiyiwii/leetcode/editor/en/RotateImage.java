//You are given an n x n 2D matrix representing an image, rotate the image by 90
// degrees (clockwise). 
//
// You have to rotate the image in-place, which means you have to modify the inp
//ut 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation. 
//
// 
// Example 1: 
//
// 
//Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
//Output: [[7,4,1],[8,5,2],[9,6,3]]
// 
//
// Example 2: 
//
// 
//Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
//Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
// 
//
// Example 3: 
//
// 
//Input: matrix = [[1]]
//Output: [[1]]
// 
//
// Example 4: 
//
// 
//Input: matrix = [[1,2],[3,4]]
//Output: [[3,1],[4,2]]
// 
//
// 
// Constraints: 
//
// 
// matrix.length == n 
// matrix[i].length == n 
// 1 <= n <= 20 
// -1000 <= matrix[i][j] <= 1000 
// 
// Related Topics Array 
// 👍 3942 👎 290


package com.yiyiwii.leetcode.editor.en;
public class RotateImage {
    public static void main(String[] args) {
        Solution solution = new RotateImage().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;
        int n = matrix.length;
        int top = 0, bottom = n - 1, left = 0, right = n - 1;
        while (top < bottom) {
            for (int i = 0; i < n - 1; i++){
                int tmp = matrix[top][left + i];
                matrix[top][left + i] = matrix[bottom - i][left];
                matrix[bottom - i][left] = matrix[bottom][right - i];
                matrix[bottom][right - i] = matrix[top + i][right];
                matrix[top + i][right] = tmp;
            }
            top++;
            bottom--;
            left++;
            right--;
            n -= 2;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}