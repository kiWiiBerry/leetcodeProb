package com.yiyiwii.leetcode.editor.en;

public class GGDecodeString {
    public static void main(String[] args) {
        GGDecodeString sol = new GGDecodeString();

        String test = "abc(d){3}";
        String testRes = sol.decodeString(test);
        System.out.println(testRes);

        String testB = "(abc(d){3}){2}";
        String testResB = sol.decodeString(testB);
        System.out.println(testResB);
    }

    int pos = 0;

    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            System.out.println("c: " + c);
            if (c == '(') {
                int matchIndex = findMatchIndex(s, i);
                String repeat = decodeString(s.substring(i + 1, matchIndex));
                i = matchIndex + 2;
                int times = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    times = times * 10 + (s.charAt(i) - '0');
                    i++;
                }
                for (int num = 0; num < times; num++) {
                    res.append(repeat);
                }
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }
    private int findMatchIndex(String s, int index) {
        int cnt = 0;
        for (; index < s.length(); index++) {
            if (s.charAt(index) == '(') {
                cnt++;
            } else if (s.charAt(index) == ')') {
                cnt--;
            }
            if (cnt == 0) break;
        }
        return index;
    }
}