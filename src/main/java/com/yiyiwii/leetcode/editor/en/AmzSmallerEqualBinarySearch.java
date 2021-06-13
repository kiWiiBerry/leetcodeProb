package com.yiyiwii.leetcode.editor.en;

public class AmzSmallerEqualBinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 4, 8, 12};
        int target = 4;
        AmzSmallerEqualBinarySearch.Solution sol = new AmzSmallerEqualBinarySearch().new Solution();
        int res = sol.binarySearch(arr, target);
        System.out.println(res);
    }
    class Solution {
        public int binarySearch (int[] arr, int target) {
            int start = 0, end = arr.length - 1;

            int ans = -1;
            while (start <= end) {
                int mid = (start + end) / 2;

                // Move to right side if target is
                // greater.
                if (arr[mid] <= target) {
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
    }
}
