package com.yiyiwii.leetcode.editor.en;

import java.util.Arrays;
import java.util.List;

public class AmzStorageOptimization {
    public static void main(String[] args) {

    }
    class Solution {
        public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
            Arrays.sort(horizontalCuts);
            Arrays.sort(verticalCuts);
            long maxH = horizontalCuts[0];
            long maxV = verticalCuts[0];

            for (int i = 0; i < horizontalCuts.length; i++) {
                maxH = Math.max(maxH, horizontalCuts[i] - horizontalCuts[i - 1]);
            }
            maxH = Math.max(maxH, h - horizontalCuts[horizontalCuts.length - 1]);

            for (int i = 0; i < verticalCuts.length; i++) {
                maxV = Math.max(maxV, verticalCuts[i] - verticalCuts[i - 1]);
            }
            maxV = Math.max(maxV, w - verticalCuts[verticalCuts.length - 1]);

            return (int)((maxH * maxV) % 1_000_000_007);
        }

    }
}

//    public static int storageOptimzation(int n, int m, int[] hRemove, int[] vRemove) {
//        Set<Integer> hRemoved = new HashSet<>();
//        Set<Integer> vRemoved = new HashSet<>();
//        for (int r : hRemove)
//            hRemoved.add(r);
//        for (int r : vRemove)
//            vRemoved.add(r);
//
//        int prevH = 0;
//        int maxHDiff = 0;
//        for (int h = 1; h <= n + 1; h++) {
//            maxHDiff = Math.max(h - prevH, maxHDiff);
//            if (!hRemoved.contains(h))
//                prevH = h;
//        }
//        int prevV = 0;
//        int maxVDiff = 0;
//        for (int v = 1; v <= m + 1; v++) {
//            maxVDiff = Math.max(v - prevV, maxVDiff);
//            if (!vRemoved.contains(v))
//                prevV = v;
//        }
//
//        return maxHDiff * maxVDiff;
//    }