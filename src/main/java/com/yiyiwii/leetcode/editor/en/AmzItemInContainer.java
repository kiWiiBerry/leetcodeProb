/**
 * Given a string s consisting of items as "*" and closed compartments as an open and close "|", an array of starting indices startIndices, and an array of ending indices endIndices, determine the number of items in closed compartments within the substring between the two indices, inclusive.
 *
 * An item is represented as an asterisk *
 * A compartment is represented as a pair of pipes | that may or may not have items between them.
 * Example:
 * s = '|**|*|*'
 * startIndices = [1,1]
 * endIndices = [5,6]
 *
 * The String has a total 2 closed compartments, one with 2 items and one with 1 item. For the first par of indices, (1,5), the substring is '|**|*'. There are 2 items in a compartment.
 * For the second pair of indices, (1,6), the substring is '|**|*|' and there 2+1=3 items in compartments.
 * Both of the answers are returned in an array. [2,3].
 * */
package com.yiyiwii.leetcode.editor.en;

import java.util.*;

public class AmzItemInContainer {
    public static void main(String[] args) {
        String s = "|**|*|*";
        List<Integer> startIndices = new ArrayList<Integer>(Arrays.asList(0,0));
        List<Integer> endIndices = new ArrayList<Integer>(Arrays.asList(4,5));

        AmzItemInContainer.Solution sol = new AmzItemInContainer().new Solution();
        List<Integer> res = sol.numberOfItems(s, startIndices, endIndices);
//        System.out.println();
    }
    class Solution {
        public List<Integer> numberOfItems(String s, List<Integer> startIndices, List<Integer> endIndices) {
            HashMap<Integer, Integer> map = new HashMap<>();
            int len = s.length();
            int preSum = 0;
            for (int i = 0; i < len; i++) {
                if (s.charAt(i) == '|') {
                    map.put(i, preSum);
                } else {
                    preSum++;
                }
            }
            int[] leftB = new int[len];
            int divider = -1;
            for (int i = 0; i < len; i++) {
                if (s.charAt(i) == '|') {
                    divider = i;
                }
                leftB[i] = divider;
            }
            System.out.println(Arrays.toString(leftB));

            int[] rightB = new int[len];
            divider = -1;
            for (int i = len - 1; i >= 0; i--) {
                if (s.charAt(i) == '|') {
                    divider = i;
                }
                rightB[i] = divider;
            }
            System.out.println(Arrays.toString(rightB));

            ArrayList<Integer> res = new ArrayList<>();
            for (int i = 0; i < startIndices.size(); i++) {
                int st = rightB[startIndices.get(i)];
                int end = leftB[endIndices.get(i)];
                if (st != -1 && end != -1 && st < end) {
                    res.add(map.get(end) - map.get(st));
                } else {
                    res.add(0);
                }
            }
            System.out.println(Arrays.toString(res.toArray()));
            return res;
        }
    }
}
