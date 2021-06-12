package com.yiyiwii.leetcode.editor.en;

import java.util.Arrays;

public class AmzMeanderingArray {

    public class Solution {
        public int[] rearrangeArray(int[] arr) {
            Arrays.sort(arr);
            int n = arr.length;
            int[] tmp = new int[n];
            int idx = 0;
            for (int i=0, j=n-1; i<=n/2||j>n/2; i++, j--) {
                if (idx < n) {
                    tmp[idx] = arr[i];
                    idx++;
                }
                if (idx < n) {
                    tmp[idx] = arr[j];
                    idx++;
                }
            }
            return tmp;
        }
    }
}
