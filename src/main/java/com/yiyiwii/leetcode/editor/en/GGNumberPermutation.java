package com.yiyiwii.leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GGNumberPermutation {
    public static void main(String[] args) {
        GGNumberPermutation sol = new GGNumberPermutation();
        int[] nums = {1,2,3,4,5,6,7, 8, 9};
        sol.rearrange(nums);
    }
    public void rearrange(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.sort(res);
        System.out.println(Arrays.toString(nums));
        partition(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    public void partition (int[] nums, int left, int right) {
        if (left >= right) return;

        shuffle(nums, left, right);

        int mid = left + (right - left) / 2;
        partition(nums, left, mid);
        partition(nums, mid + 1, right);
    }

    public void shuffle (int[] nums, int left, int right) {
        int len = right - left + 1;

        int[] tmp = new int[len];
        int lenEven = len / 2;
        for (int i = left; i <= right; i++) {
            int k = i - left;
            if (i % 2 != 0) {
                tmp[k / 2 + (len - lenEven)] = nums[i];
            } else {
                tmp[k / 2] = nums[i];
            }
        }

        System.arraycopy(tmp, 0, nums, left, right - left + 1);
    }

}
