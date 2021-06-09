//You are given an array of logs. Each log is a space-delimited string of words,
// where the first word is the identifier. 
//
// There are two types of logs: 
//
// 
// Letter-logs: All words (except the identifier) consist of lowercase English l
//etters. 
// Digit-logs: All words (except the identifier) consist of digits. 
// 
//
// Reorder these logs so that: 
//
// 
// The letter-logs come before all digit-logs. 
// The letter-logs are sorted lexicographically by their contents. If their cont
//ents are the same, then sort them lexicographically by their identifiers. 
// The digit-logs maintain their relative ordering. 
// 
//
// Return the final order of the logs. 
//
// 
// Example 1: 
//
// 
//Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","le
//t3 art zero"]
//Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig
//2 3 6"]
//Explanation:
//The letter-log contents are all different, so their ordering is "art can", "ar
//t zero", "own kit dig".
//The digit-logs have a relative order of "dig1 8 1 5 1", "dig2 3 6".
// 
//
// Example 2: 
//
// 
//Input: logs = ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act z
//oo"]
//Output: ["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
// 
//
// 
// Constraints: 
//
// 
// 1 <= logs.length <= 100 
// 3 <= logs[i].length <= 100 
// All the tokens of logs[i] are separated by a single space. 
// logs[i] is guaranteed to have an identifier and at least one word after the i
//dentifier. 
// 
// Related Topics String 
// 👍 1124 👎 2972


package com.yiyiwii.leetcode.editor.en;

import java.util.Arrays;
import java.util.Comparator;

public class ReorderDataInLogFiles {
    public static void main(String[] args) {
        Solution solution = new ReorderDataInLogFiles().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Comparator<String> comparator = new Comparator<String>(){
            @Override
            public int compare(String str1, String str2) {
                String[] split1 = str1.split(" ", 2);
                String[] split2 = str2.split(" ", 2);
                boolean isNum1 = Character.isDigit(split1[1].charAt(0));
                boolean isNum2 = Character.isDigit(split2[1].charAt(0));

                if (!isNum1 && !isNum2) { // both are letter logs
                    int res = split1[1].compareTo(split2[1]);  // sort the content
                    if (res != 0){
                        return res;
                    }

                    // if same content, return by the identifiers
                    return split1[0].compareTo(split2[0]);
                }
                return (isNum1) ? (isNum2 ? 0 : 1): -1;
            }
        };
        Arrays.sort(logs, comparator);
        return logs;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}