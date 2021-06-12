package com.yiyiwii.leetcode.editor.en;

import java.util.*;

public class AmzOptimizeBoxWeight {
    public static void main(String[] args) {
        AmzOptimizeBoxWeight.Solution sol = new AmzOptimizeBoxWeight().new Solution();
//        int[] array = {1,2,3,4};
//        int[] array = {3,7,5,6,2};
//        int[] array = {5,3,2,4,1,2};
        int[] array = {4,2,5,1,6};
        int[] res = sol.minimalHeaviestSetA(array);
        System.out.println(Arrays.toString(res));
    }
    class Solution {
        public int[] minimalHeaviestSetA (int[] arr) {
            List<Integer> res = new ArrayList<>();
            int sum = 0, target = Arrays.stream(arr).sum() / 2;
            arr = Arrays.stream(arr).boxed().sorted(Collections.reverseOrder())
                    .mapToInt(Integer::intValue).toArray();
            System.out.println(Arrays.toString(arr));

            for (int num : arr) {
                sum += num;
                res.add(num);
                if (sum > target) {
                    break;
                }
            }
            return res.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}
