//Design a data structure that supports adding new words and finding if a string
// matches any previously added string. 
//
// Implement the WordDictionary class: 
//
// 
// WordDictionary() Initializes the object. 
// void addWord(word) Adds word to the data structure, it can be matched later. 
//
// bool search(word) Returns true if there is any string in the data structure t
//hat matches word or false otherwise. word may contain dots '.' where dots can be
// matched with any letter. 
// 
//
// 
// Example: 
//
// 
//Input
//["WordDictionary","addWord","addWord","addWord","search","search","search","se
//arch"]
//[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
//Output
//[null,null,null,null,false,true,true,true]
//
//Explanation
//WordDictionary wordDictionary = new WordDictionary();
//wordDictionary.addWord("bad");
//wordDictionary.addWord("dad");
//wordDictionary.addWord("mad");
//wordDictionary.search("pad"); // return False
//wordDictionary.search("bad"); // return True
//wordDictionary.search(".ad"); // return True
//wordDictionary.search("b.."); // return True
// 
//
// 
// Constraints: 
//
// 
// 1 <= word.length <= 500 
// word in addWord consists lower-case English letters. 
// word in search consist of '.' or lower-case English letters. 
// At most 50000 calls will be made to addWord and search. 
// 
// Related Topics String Depth-First Search Design Trie 
// 👍 3593 👎 150


package com.yiyiwii.leetcode.editor.en;
public class DesignAddAndSearchWordsDataStructure {
    public static void main(String[] args) {
        WordDictionary solution = new DesignAddAndSearchWordsDataStructure().new WordDictionary();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class WordDictionary {
        class TrieNode {
            TrieNode[] children = new TrieNode[26];
            boolean isWord;
            char ch;
            TrieNode(){}
            TrieNode(char ch) {
                this.ch = ch;
            }
        }

        TrieNode root;
    public WordDictionary() {
        this.root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode curr = root;
        for (char ch : word.toCharArray()) {
            if (curr.children[ch - 'a'] == null) {
                curr.children[ch - 'a'] = new TrieNode(ch);
            }
            curr = curr.children[ch - 'a'];
        }
        curr.isWord = true;
    }
    
    public boolean search(String word) {
        return match(word.toCharArray(), 0, root);
    }
    private boolean match(char[] chars, int k, TrieNode node) {
        if (k == chars.length) return node.isWord;
        if (chars[k] == '.') {
            for (int i = 0; i < node.children.length; i++) {
                if (node.children[i] != null && match(chars, k + 1, node.children[i])) {
                    return true;
                }
            }
        } else {
            return node.children[chars[k] - 'a'] != null
                    && match(chars, k + 1, node.children[chars[k] - 'a']);
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
//leetcode submit region end(Prohibit modification and deletion)

}