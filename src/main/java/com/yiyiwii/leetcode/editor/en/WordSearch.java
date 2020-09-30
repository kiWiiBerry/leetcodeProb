//Given a 2D board and a word, find if the word exists in the grid. 
//
// The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once. 
//
// Example: 
//
// 
//board =
//[
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
//]
//
//Given word = "ABCCED", return true.
//Given word = "SEE", return true.
//Given word = "ABCB", return false.
// 
//
// 
// Constraints: 
//
// 
// board and word consists only of lowercase and uppercase English letters. 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// 1 <= word.length <= 10^3 
// 
// Related Topics Array Backtracking
  
package com.yiyiwii.leetcode.editor.en;
public class WordSearch{
    public static void main(String[] args) {
        Solution solution = new WordSearch().new Solution();
    }
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == word.charAt(0)) {
                    if (dfs(r, c, board, visited, word, 0))
                        return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(int r, int c, char[][] board,
                       boolean[][] visited, String word, int index) {
        if (index == word.length())
            return true;
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length
                || board[r][c] != word.charAt(index) || visited[r][c])
            return false;
        visited[r][c] = true;
        boolean res = dfs(r + 1, c, board, visited, word, index + 1)
                || dfs(r, c + 1, board, visited, word, index + 1)
                || dfs(r - 1, c, board, visited, word, index + 1)
                || dfs(r, c - 1, board, visited, word, index + 1);
        visited[r][c] = false;
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}