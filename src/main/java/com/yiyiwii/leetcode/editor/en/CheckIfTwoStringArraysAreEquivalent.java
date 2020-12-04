//Given two string arrays word1 and word2, return true if the two arrays represe
//nt the same string, and false otherwise. 
//
// A string is represented by an array if the array elements concatenated in ord
//er forms the string. 
//
// 
// Example 1: 
//
// 
//Input: word1 = ["ab", "c"], word2 = ["a", "bc"]
//Output: true
//Explanation:
//word1 represents string "ab" + "c" -> "abc"
//word2 represents string "a" + "bc" -> "abc"
//The strings are the same, so return true. 
//
// Example 2: 
//
// 
//Input: word1 = ["a", "cb"], word2 = ["ab", "c"]
//Output: false
// 
//
// Example 3: 
//
// 
//Input: word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
//Output: true
// 
//
// 
// Constraints: 
//
// 
// 1 <= word1.length, word2.length <= 103 
// 1 <= word1[i].length, word2[i].length <= 103 
// 1 <= sum(word1[i].length), sum(word2[i].length) <= 103 
// word1[i] and word2[i] consist of lowercase letters. 
// 
// Related Topics String 
// 👍 76 👎 15


package com.yiyiwii.leetcode.editor.en;
public class CheckIfTwoStringArraysAreEquivalent {
    public static void main(String[] args) {
        Solution solution = new CheckIfTwoStringArraysAreEquivalent().new Solution();
        String[] word1 = new String[]{"ab", "c"};
        String[] word2 = new String[]{"a", "bc"};
        solution.arrayStringsAreEqual(word1, word2);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder();
        for (int i = 0; i < word1.length; i++) {
            sb1.append(word1[i]);
        }
        System.out.println("1: " + sb1.toString());

        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < word2.length; i++) {
            sb2.append(word2[i]);
        }
        System.out.println("2: " + sb2.toString());

        System.out.println(sb1.toString().equals(sb2.toString()));
        return sb1.toString().equals(sb2.toString());
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}