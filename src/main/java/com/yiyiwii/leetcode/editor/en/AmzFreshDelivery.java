package com.yiyiwii.leetcode.editor.en;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class AmzFreshDelivery {
    public static void main(String[] args) {

    }
    class Solution {
        public int[][] kNearestPairs(int[][] locations, int K) {
            int[][] res = new int[K][2];
            PriorityQueue<int[]> pq = new PriorityQueue<>(K,
                    (a, b) -> (b[0] * b[0] + b[1] * b[1])-(a[0] * a[0] + a[1] * a[1]));
            for (int[] point : locations) {
                pq.offer(point);
                if (pq.size() > K) {
                    pq.poll();
                }
            }
            res = pq.toArray(new int[K][2]);
            Arrays.sort(res, Comparator.comparing(x -> ((int[])x)[0]).thenComparing(x -> ((int[])x)[1]));
            return res;
        }
    }
}
