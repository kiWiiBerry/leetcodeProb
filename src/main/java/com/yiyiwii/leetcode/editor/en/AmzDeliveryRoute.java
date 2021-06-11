package com.yiyiwii.leetcode.editor.en;

import java.util.LinkedList;
import java.util.Queue;

public class AmzDeliveryRoute {
    public static void main(String[] args) {
        int[][] routes = {{1,0,0},{1,0,0},{1,9,1}};
        int[][] routes2 = {{1,1,1,1},{1,1,0,1},{9,1,0,1}};
        Solution sol = new AmzDeliveryRoute().new Solution();
        int res = sol.deliverRoute(routes2);
        System.out.println(res);
    }
    class Solution {
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        public int deliverRoute(int[][] routes) {
            int rowL = routes.length, colL = routes[0].length;

            int res = -1;
            Queue<Integer[]> queue = new LinkedList<>();
            queue.offer(new Integer[]{0,0});
            while (!queue.isEmpty()) {
                int size = queue.size();
                res++;

                for (int i = 0; i < size; i++) {
                    Integer[] pt = queue.poll();
                    for (int[] neighbor : dirs) {
                        int r = pt[0] + neighbor[0];
                        int c = pt[1] + neighbor[1];
                        if (r >= 0 && r < rowL && c >= 0 && c < colL
                                && routes[r][c] != 0) {
                            if (routes[r][c] == 1) {
                                routes[r][c] = 0;
                                queue.offer(new Integer[]{r, c});
                            } else if (routes[r][c] == 9) {
                                res++;
                                return res;
                            }
                        }
                    }
                }
            }
            return res;
        }
    }
}
