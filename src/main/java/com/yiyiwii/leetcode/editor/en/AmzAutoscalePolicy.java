package com.yiyiwii.leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AmzAutoscalePolicy {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(46, 73, 77, 53, 75, 22, 55, 84, 45, 40, 80, 66, 54, 39, 68, 23, 54, 22, 11, 91, 47, 56, 91, 97, 5, 44, 62, 73, 26, 99, 96, 74, 4, 0, 8, 56, 3, 21, 37, 94, 83, 68, 91, 83, 41, 22, 81, 59, 37, 29, 93, 8, 88, 41, 94, 62, 63, 97, 73, 46, 80, 91, 65, 69, 52, 31, 35, 81, 60, 44, 8, 80, 75, 94, 16, 45, 12, 29, 22, 59, 88, 87, 55, 43, 67, 8, 15, 26, 31, 99, 35, 99, 1, 98));
        int n = 500;
        System.out.println(list.size());
    }
    class Solution {
        public int autoScale(List<Integer> averageUtils, int numInstances) {
            int instances = numInstances;
            for (int i = 0; i < averageUtils.size(); i++) {
                int util = averageUtils.get(i);
                if (util > 60) {
                    if (instances <= Math.pow(10, 8)) {
                        instances *= 2;
                        i += 10;
                    }
                } else if (util < 25) {
                    if (instances > 1) {
                        instances = (instances + 1) / 2;
                        i += 10;
                    }
                }
            }
            return instances;
        }
    }
}