package com.yiyiwii.leetcode.editor.en;

import java.util.*;

public class AmzShoppingOptions {
    public static void main(String[] args) {
        AmzShoppingOptions.Solution sol = new AmzShoppingOptions().new Solution();
        int[] nums1 = {1}; //{4}; //{2,3}; //{1,3,4};
        int[] nums2 = {4}; //{3,4,1}; //{4};
        int[] nums3 = {3}; //{3,2}; //{2,3}; //{2,4};
        int[] nums4 = {1}; //{4}; //{1,2};
        int money = 3; //12; // 10;
        int res = sol.shoppingOption(nums1, nums2, nums3, nums4, money);
        System.out.println(res);

//        Map<Integer, Integer> mapCD = sol.createMap(nums1, nums2);
//        List<Map.Entry<Integer, Integer>> listCD = new ArrayList<>(mapCD.entrySet());
//
//        listCD.forEach((e)
//                -> System.out.println(e.getKey() + ": " + e.getValue()));

//        int test = sol.binarySearch(listCD, 2);
//        System.out.println(test);
    }
    class Solution {
        public int shoppingOption(int[] nums1, int[] nums2,
                                  int[] nums3, int[] nums4, int money) {
            Map<Integer, Integer> mapAB = createMap(nums1, nums2);
            Map<Integer, Integer> mapCD = createMap(nums3, nums4);
            List<Map.Entry<Integer, Integer>> listCD = new ArrayList<>(mapCD.entrySet());
            List<Map.Entry<Integer, Integer>> listAB = new ArrayList<>(mapAB.entrySet());

            listCD.sort(Map.Entry.comparingByKey());
//            listCD.forEach((e)
//                    -> System.out.println(e.getKey() + ": " + e.getValue()));

            int[] preSum = new int[listCD.size()];
            preSum[0] = listCD.get(0).getValue();
            for (int i = 1; i < listCD.size(); i++) {
                preSum[i] = preSum[i - 1] + listCD.get(i).getValue();
            }
//            System.out.println(Arrays.toString(preSum));

            int total = 0;
            for (int i = 0; i < listAB.size(); i++) {
                int sumAB = listAB.get(i).getKey();
                int targetCD = money - sumAB;
//                System.out.println("SumAB: " + sumAB + "; TargetCD: " + targetCD);
                int split = binarySearch(listCD, targetCD);

                int tmp = 0;
                if (split == 0) {
                    tmp = 0;
                } else if(split == -1) {
                    tmp = listAB.get(i).getValue() * preSum[listCD.size() - 1];
                } else {
                    tmp = listAB.get(i).getValue() * preSum[split - 1];
                }
                System.out.println("KeyAB: " + listAB.get(i).getKey()
                        + "; ValueAB: " + listAB.get(i).getValue());
                System.out.println("AB way: " + tmp);
                total += tmp;
            }

            return total;
        }

        private int binarySearch(List<Map.Entry<Integer, Integer>> list, int target) {
            int start = 0, end = list.size() - 1;

            int ans = -1;
            while (start <= end) {
                int mid = start + (end - start) / 2;

                // Move to right side if target is
                // greater.
                if (list.get(mid).getKey() <= target) {
                    start = mid + 1;
                }

                // Move left side.
                else {
                    ans = mid;
                    end = mid - 1;
                }
            }
            return ans;
        }

        private Map<Integer, Integer> createMap(int[] arrA, int[] arrB) {
            Map<Integer, Integer> mapAB = new HashMap<>();
            for (int i = 0; i < arrA.length; i++) {
                for (int j = 0; j < arrB.length; j++) {
                    int sum = arrA[i] + arrB[j];
                    mapAB.put(sum, mapAB.getOrDefault(sum, 0) + 1);
                }
            }
            return mapAB;
        }
    }
}
