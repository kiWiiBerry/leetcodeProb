//Given two words (beginWord and endWord), and a dictionary's word list, find al
//l shortest transformation sequence(s) from beginWord to endWord, such that: 
//
// 
// Only one letter can be changed at a time 
// Each transformed word must exist in the word list. Note that beginWord is not
// a transformed word. 
// 
//
// Note: 
//
// 
// Return an empty list if there is no such transformation sequence. 
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
//Output:
//[
//  ["hit","hot","dot","dog","cog"],
//  ["hit","hot","lot","log","cog"]
//]
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
//Output: []
//
//Explanation: The endWord "cog" is not in wordList, therefore no possible trans
//formation.
// 
//
// 
// 
// Related Topics Array String Backtracking Breadth-first Search 
// 👍 1815 👎 250

  
package com.yiyiwii.leetcode.editor.en;

import java.util.*;

public class WordLadderIi {
    public static void main(String[] args) {
        Solution solution = new WordLadderIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList){
        List<List<String>> res = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordList);
        Map<String, List<String>> nodeNeighbors = new HashMap<>();
        Map<String, Integer> distance = new HashMap<>();
        List<String> list = new ArrayList<String>();

        dict.add(beginWord);
        bfs(beginWord, endWord, wordList, dict, nodeNeighbors, distance);
        dfs(beginWord, endWord, dict, nodeNeighbors, distance, list, res);
        return res;
    }

    public void bfs(String beginWord, String endWord, List<String> wordList,
                                  Set<String> dict, Map<String, List<String>> nodeNeighbors,
                                  Map<String, Integer> distance) {
        for (String str : dict) {
            nodeNeighbors.put(str, new ArrayList<String>());
        }
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        distance.put(beginWord, 0);

        while (!q.isEmpty()) {
            int size = q.size();
            boolean foundEnd = false;
            for (int i = 0; i < size; i++) {
                String curr = q.remove();
                int currDist = distance.get(curr);

                List<String> children = getNeighbors(dict, curr);
                for (String child : children) {
                    nodeNeighbors.get(curr).add(child);
                    if (!distance.containsKey(child)){
                        distance.put(child, currDist + 1);
                        if (child.equals(endWord)) {
                            foundEnd = true;
                        } else {
                            q.offer(child);
                        }
                    }
                }
                if (foundEnd)
                    break;
            }
        }

    }

    private List<String> getNeighbors(Set<String> dict, String node) {
        List<String> res = new ArrayList<>();
        char[] chars = node.toCharArray();

        for (int i = 0; i < node.length(); i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (chars[i] == ch) continue;
                char oldChar = chars[i];
                chars[i] = ch;
                if (dict.contains(String.valueOf(chars))){
                    res.add(String.valueOf(chars));
                }
                chars[i] = oldChar;
            }
        }
        return res;
    }

    private void dfs(String cur, String endWord, Set<String> dict,
                     Map<String, List<String>> nodeNeighbors,
                     Map<String, Integer> distance, List<String> solution,
                     List<List<String>> res) {
        solution.add(cur);
        if (endWord.equals(cur)){
            res.add(new ArrayList<String>(solution));
        } else {
            for (String child : nodeNeighbors.get(cur)) {
                if (distance.get(cur) + 1 == distance.get(child)) {
                    dfs(child, endWord, dict, nodeNeighbors, distance, solution, res);
                }
            }
        }
        solution.remove(solution.size() - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}