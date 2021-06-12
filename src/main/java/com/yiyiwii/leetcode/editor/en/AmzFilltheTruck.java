package com.yiyiwii.leetcode.editor.en;

import java.util.Arrays;

public class AmzFilltheTruck {
    public static void main(String[] args) {

    }
    class Solution {
        public int maximumUnits(int[][] boxTypes, int truckSize) {
            Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
            int res = 0;
            for (int i = 0; truckSize > 0 && i < boxTypes.length; i++) {
                int cnt = Math.min(truckSize, boxTypes[i][0]);
                res += cnt * boxTypes[i][1];
                truckSize -= cnt;
            }
            return res;
        }
    }
}
