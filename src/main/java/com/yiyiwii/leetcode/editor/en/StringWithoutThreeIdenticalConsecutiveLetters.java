package com.yiyiwii.leetcode.editor.en;

public class StringWithoutThreeIdenticalConsecutiveLetters {
    public static void main(String[] args) {
        Solution solution = new StringWithoutThreeIdenticalConsecutiveLetters().new Solution();
        String s1 = "eedaaad";
        String s2 = "xxxtxxx";
        String s3 = "uuuuxaaaaxuuu";
        System.out.println(solution.getLongestSubstring(s1));
        System.out.println(solution.getLongestSubstring(s2));
        System.out.println(solution.getLongestSubstring(s3));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String getLongestSubstring(String s) {
            StringBuilder sb = new StringBuilder();
            sb.append(s.charAt(0));
            int cnt = 1;
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == s.charAt(i - 1)) {
                    cnt++;
                } else {
                    cnt = 1;
                }
                if (cnt < 3) {
                    sb.append(s.charAt(i));
                }
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}