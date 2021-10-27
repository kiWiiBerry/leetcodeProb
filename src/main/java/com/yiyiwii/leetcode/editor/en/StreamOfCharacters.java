//Design an algorithm that accepts a stream of characters and checks if a suffix
// of these characters is a string of a given array of strings words. 
//
// For example, if words = ["abc", "xyz"] and the stream added the four characte
//rs (one by one) 'a', 'x', 'y', and 'z', your algorithm should detect that the su
//ffix "xyz" of the characters "axyz" matches "xyz" from words. 
//
// Implement the StreamChecker class: 
//
// 
// StreamChecker(String[] words) Initializes the object with the strings array w
//ords. 
// boolean query(char letter) Accepts a new character from the stream and return
//s true if any non-empty suffix from the stream forms a word that is in words. 
// 
//
// 
// Example 1: 
//
// 
//Input
//["StreamChecker", "query", "query", "query", "query", "query", "query", "query
//", "query", "query", "query", "query", "query"]
//[[["cd", "f", "kl"]], ["a"], ["b"], ["c"], ["d"], ["e"], ["f"], ["g"], ["h"], 
//["i"], ["j"], ["k"], ["l"]]
//Output
//[null, false, false, false, true, false, true, false, false, false, false, fal
//se, true]
//
//Explanation
//StreamChecker streamChecker = new StreamChecker(["cd", "f", "kl"]);
//streamChecker.query("a"); // return False
//streamChecker.query("b"); // return False
//streamChecker.query("c"); // return False
//streamChecker.query("d"); // return True, because 'cd' is in the wordlist
//streamChecker.query("e"); // return False
//streamChecker.query("f"); // return True, because 'f' is in the wordlist
//streamChecker.query("g"); // return False
//streamChecker.query("h"); // return False
//streamChecker.query("i"); // return False
//streamChecker.query("j"); // return False
//streamChecker.query("k"); // return False
//streamChecker.query("l"); // return True, because 'kl' is in the wordlist
// 
//
// 
// Constraints: 
//
// 
// 1 <= words.length <= 2000 
// 1 <= words[i].length <= 2000 
// words[i] consists of lowercase English letters. 
// letter is a lowercase English letter. 
// At most 4 * 104 calls will be made to query. 
// 
// Related Topics Array String Design Trie Data Stream 
// 👍 924 👎 131


package com.yiyiwii.leetcode.editor.en;
public class StreamOfCharacters {
    public static void main(String[] args) {
        String[] testCases = {"abaa","abaab","aabbb","bab","ab"};
        StreamChecker solution = new StreamOfCharacters().new StreamChecker(testCases);
        //,["a"],["a"],["b"],["b"],["b"]]
        System.out.println(solution.query('a'));
        solution.query('a');
        solution.query('b');
        solution.query('b');
        solution.query('b');
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class StreamChecker {

        class TrieNode {
            TrieNode[] children = new TrieNode[26];
            boolean isWord;
            char ch;
            TrieNode(){}
            TrieNode(char ch) {
                this.ch = ch;
            }
        }
        private TrieNode root;
        StringBuilder sb;
        int maxLen = 0;

        public StreamChecker(String[] words) {
            this.root = new TrieNode();
            for (String word : words) {
                maxLen = Math.max(maxLen, word.length());
                insert(word);
            }
            sb = new StringBuilder();
        }

        public void insert(String word) {
            TrieNode curr = this.root;
            int len = word.length();
            for (int i = len - 1; i >= 0; i--) {
                char ch = word.charAt(i);
                if (curr.children[ch - 'a'] == null) {
                    curr.children[ch - 'a'] = new TrieNode(ch);
                }
                curr = curr.children[ch - 'a'];
            }
            curr.isWord = true;
        }

        public boolean query(char letter) {
            this.sb.append(letter);
            int len = this.sb.length();

            int minLen = Math.min(maxLen, len);
            String word = this.sb.substring(len - minLen, len);

            TrieNode curr = this.root;
            for (int i = word.length() - 1; i >= 0; i--) {
                char ch = word.charAt(i);
                curr = curr.children[ch - 'a'];

                if (curr == null) {
                    return false;
                }
                if (curr.isWord) return true;
            }

            return curr.isWord;
        }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
//leetcode submit region end(Prohibit modification and deletion)

}