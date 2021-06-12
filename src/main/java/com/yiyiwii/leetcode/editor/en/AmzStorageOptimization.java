package com.yiyiwii.leetcode.editor.en;

import java.util.Arrays;
import java.util.List;

public class AmzStorageOptimization {
    public static void main(String[] args) {

    }
    class Solution {
        public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
            int maxH = 0;
            int maxV = 0;

            Arrays.sort(horizontalCuts);
            Arrays.sort(verticalCuts);

            for (int i = 0; i < horizontalCuts.length; i++) {
                maxH = Math.max(maxH, i == 0 ? horizontalCuts[i] : horizontalCuts[i] - horizontalCuts[i - 1]);
            }
            maxH = Math.max(maxH, h - horizontalCuts[horizontalCuts.length - 1]);

            for (int i = 0; i < verticalCuts.length; i++) {
                maxV = Math.max(maxV, i == 0 ? verticalCuts[i] : verticalCuts[i] - verticalCuts[i - 1]);
            }
            maxV = Math.max(maxV, h - verticalCuts[verticalCuts.length - 1]);

            return (int)(maxH % (1e9 + 7) * maxV % (1e9 + 7));
        }

    }
}