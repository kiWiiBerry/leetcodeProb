//Given two words (beginWord and endWord), and a dictionary's word list, find th
//e length of shortest transformation sequence from beginWord to endWord, such tha
//t: 
//
// 
// Only one letter can be changed at a time. 
// Each transformed word must exist in the word list. 
// 
//
// Note: 
//
// 
// Return 0 if there is no such transformation sequence. 
// All words have the same length. 
// All words contain only lowercase alphabetic characters. 
// You may assume no duplicates in the word list. 
// You may assume beginWord and endWord are non-empty and are not the same. 
// 
//
// Example 1: 
//
// 
//Input:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//Output: 5
//
//Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog
//" -> "cog",
//return its length 5.
// 
//
// Example 2: 
//
// 
//Input:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//Output: 0
//
//Explanation: The endWord "cog" is not in wordList, therefore no possible trans
//formation.
// 
//
// 
// 
// Related Topics Breadth-first Search 
// 👍 3283 👎 1187

  
package com.yiyiwii.leetcode.editor.en;

import java.util.*;

public class WordLadder {
    public static void main(String[] args) {
        Solution solution = new WordLadder().new Solution();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        int res = solution.ladderLength(beginWord, endWord, wordList);

        System.out.println(res);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int step = 0;
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord))
            return step;

        int wordLen = beginWord.length();

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);

        while (!q.isEmpty()) {
            step++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String curr = q.poll();
                char[] currChars = curr.toCharArray();
                for (int j = 0; j < wordLen; j++) {
                    char pre = currChars[j];
                    for (char candidate = 'a'; candidate <= 'z'; candidate++) {
                        if (candidate == currChars[j])
                            continue;
                        currChars[j] = candidate;
                        String testWord = new String(currChars);
                        if (!dict.contains(testWord))
                            continue;
                        if (testWord.equals(endWord))
                            return step + 1;
                        dict.remove(testWord);
                        q.add(testWord);
                    }
                    currChars[j] = pre;
                }
            }
        }

        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}