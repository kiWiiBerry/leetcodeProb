package com.yiyiwii.leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

// Two sets of six faced dices, represented as arrays A and B consisting of N and M intergers.
// Given two arrays write a function which returns the minimum number of dice to be turned in
// order to make the sums of dice to be equal or -1 if its not possible.
//
//        Given A = [5] B=[1,1,5] return 1, as 5 == 1 + 1 + 3
public class MsMinTurnTwoEqualSumDice {
    public static void main(String[] args) {

        MsMinTurnTwoEqualSumDice eg = new MsMinTurnTwoEqualSumDice();
//        int[] A = new int[]{2, 4};   // sum = 6  //{5, 6};
//        int[] B = new int[]{6,1,1,1,1,1,1};     // sum = 12  //{1, 1, 6};

        int[] A = new int[]{2, 3, 1, 1, 2};
        int[] B = new int[]{5, 4, 6};       // return 2
//
//        int[] A = new int[]{1,2,3,4,3,2,1};
//        int[] B = new int[]{6};             // return -1;

//        int[] A = new int[]{5,4,1,2,6,5};
//        int[] B = new int[]{2};             // return 6;

        System.out.println(eg.solution(A, B));
    }

    public int solution(int[] A, int[] B) {
        int sumA = Arrays.stream(A).sum(), sumB = Arrays.stream(B).sum();
        int diff = sumA - sumB;

        List<Integer> listA = Arrays.stream(A).boxed().collect(Collectors.toList());
        List<Integer> listB = Arrays.stream(B).boxed().collect(Collectors.toList());

        List<Integer> lessSum, largerSum;
        if (diff == 0) {
            return 0;
        } else {
            lessSum = (diff < 0) ? listA : listB;
            largerSum = (diff < 0) ? listB : listA;
        }
        System.out.println(lessSum.toString());
        System.out.println(largerSum.toString());
        System.out.println(diff);

        Collections.sort(lessSum);        // ascending
        Collections.sort(largerSum, Collections.reverseOrder());  //descending

        int cnt = 0, val = 0;
        int val_min_inx = 0, val_max_inx = 0;
        while (val < Math.abs(diff)) {
            int val_min = lessSum.get(val_min_inx);
            int val_max = largerSum.get(val_max_inx);
            if (val_min == 6 && val_max == 1)
                return -1;
            int diff_if_min = 6 - val_min;
            int diff_if_max = val_max - 1;
            cnt += 1;
            val += Math.max(diff_if_min, diff_if_max);

            if (diff_if_min > diff_if_max) {
                lessSum.set(val_min_inx, 6);
                val_min_inx = Math.min(val_min_inx + 1, lessSum.size() - 1);
            } else {
                largerSum.set(val_max_inx, 1);
                val_max_inx = Math.min(val_max_inx + 1, largerSum.size() - 1);
            }
        }
        return cnt;
    }
}