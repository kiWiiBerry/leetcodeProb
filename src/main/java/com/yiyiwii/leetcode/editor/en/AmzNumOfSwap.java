package com.yiyiwii.leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

public class AmzNumOfSwap {
    class Solution {
        int count;
        public int numberOfSwap(List<Integer> nums) {
            mergeSort(nums);
            return count;
        }

        public List<Integer> mergeSort(List<Integer> list) {
            if (list.size() <= 1) {
                return list;
            }

            int mid = list.size() / 2;
            List<Integer> left = mergeSort(list.subList(0, mid));
            List<Integer> right = mergeSort(list.subList(mid, list.size()));
            return merge(left, right);
        }

        public List<Integer> merge(List<Integer> left, List<Integer> right) {
            List<Integer> result = new ArrayList<>();
            int l = 0, r = 0;
            while (l < left.size() || r < right.size()) {
                if (r >= right.size() || (l < left.size() && left.get(l) <= right.get(r))) {
                    result.add(left.get(l));
                    count += r;
                    l++;
                } else {
                    result.add(right.get(r));
                    r++;
                }
            }
            return result;
        }
    }
}
