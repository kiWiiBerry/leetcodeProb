/**
 * John wants to choose 2 movies when on flight
 * Given a list of movie lengths, and the flight length
 *
 * */
package com.yiyiwii.leetcode.editor.en;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AmzTwoSumLessThanK {
    public static void main(String[] args) {

//        int[] movie_duration1 = {90, 85, 75, 60, 120, 150, 125};
//        int d1 = 250;
        Solution sol = new AmzTwoSumLessThanK().new Solution();
//        System.out.println(Arrays.toString(sol.solve(movie_duration1,d1)));
//        int[] movie_duration2 = {90, 85, 75, 60, 155, 150, 125};
//        int d2 = 250;
//        System.out.println(Arrays.toString(sol.solve(movie_duration2,d2)));
//        int[] movie_duration3 = {90, 85, 75, 60, 120, 110, 110, 150, 125};
//        int d3 = 250;
//        System.out.println(Arrays.toString(sol.solve(movie_duration3,d3)));

        int[] movie_duration4 = {10,20,30,30,40};
        int d4 = 90;
        System.out.println(Arrays.toString(sol.solve(movie_duration4,d4)));
    }
    //using sorting
    class Solution {
        int[] solve(int[] nums, int d){
            int k = d - 30;
            int[][] input = new int[nums.length][2];
            for (int i = 0; i < nums.length; i++) {
                input[i][0] = nums[i];
                input[i][1] = i;
            }
            // Ascending sort input
            // Arrays.sort(input, (a, b) -> a[0] - b[0]);
            Arrays.sort(input, Comparator.comparingInt(a -> a[0]));

            int i = 0, j = 0;
            int l = 0, r = input.length - 1;
            int sum = 0;
            while (l < r) {
                int a = input[l][0], b = input[r][0];
                if (a + b <= k) {
                    if (sum < a + b) { // update the max sum
                        sum = a + b;
                        i = input[l][1];
                        j = input[r][1];
                    }
                    l++;
                } else {
                    r--;
                }
            }
            return new int[]{i,j};
        }

//    public static void main(String[] args) {
//        int[] movies = {65, 150, 90, 90, 85, 65, 75, 60, 120, 150, 125};
//        int K = 250;
//        Solution sol = new AmzTwoSumLessThanK().new Solution();
//        int[] res = sol.towSumLessThanK(movies, K);
//        System.out.println(Arrays.toString(res));
//    }
//
//    class Solution {
//        public int[] towSumLessThanK(int[] A, int K) {
//            // Sort the array
//            Arrays.sort(A);
//            System.out.println(Arrays.toString(A));
//            int k = K - 30;
//
//            // Put pointer at begin / end
//            int l = 0, r = A.length - 1;
//            int[] res = new int[3];
//            int ans = -1;
//            while (l < r) {
//                if (A[l] + A[r] <= k) {
//                    System.out.println("l: " + l + "; r: " + r);
//
//                    System.out.println("l: " + A[l] + "; r: " + A[r]);
//                    if (ans < A[l] + A[r]) {
//                        res[1] = A[l];
//                        res[2] = A[r];
//                    }
//                    ans = Math.max(ans, A[l] + A[r]);
//                    res[0] = ans;
//
//                    l++;
//                } else {
//                    r--;
//                }
//            }
//            return res;
//        }
    }
}
