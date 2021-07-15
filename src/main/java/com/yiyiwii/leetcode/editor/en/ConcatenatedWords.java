//Given an array of strings words (without duplicates), return all the concatena
//ted words in the given list of words. 
//
// A concatenated word is defined as a string that is comprised entirely of at l
//east two shorter words in the given array. 
//
// 
// Example 1: 
//
// 
//Input: words = ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses"
//,"rat","ratcatdogcat"]
//Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]
//Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats"; 
//"dogcatsdog" can be concatenated by "dog", "cats" and "dog"; 
//"ratcatdogcat" can be concatenated by "rat", "cat", "dog" and "cat". 
//
// Example 2: 
//
// 
//Input: words = ["cat","dog","catdog"]
//Output: ["catdog"]
// 
//
// 
// Constraints: 
//
// 
// 1 <= words.length <= 104 
// 0 <= words[i].length <= 1000 
// words[i] consists of only lowercase English letters. 
// 0 <= sum(words[i].length) <= 105 
// 
// Related Topics String Dynamic Programming Depth-First Search Trie 
// 👍 1282 👎 159


package com.yiyiwii.leetcode.editor.en;

import java.util.List;

public class ConcatenatedWords {
    public static void main(String[] args) {
        Solution solution = new ConcatenatedWords().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}