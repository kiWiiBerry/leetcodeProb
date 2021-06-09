package com.yiyiwii.leetcode.editor.en;

import java.util.*;
import java.util.stream.Collectors;

public class AmzOptimalFlightDistance {
    public static void main(String[] args) {
        List<List<Integer>> routeA = Arrays.asList(Arrays.asList(1, 3000), Arrays.asList(2, 5000), Arrays.asList(3, 7000), Arrays.asList(4, 10000));
        List<List<Integer>> routeB = Arrays.asList(Arrays.asList(1, 3000), Arrays.asList(2, 9000), Arrays.asList(3, 5000));
        int K = 10000;
        System.out.println(routeA.toString());
        System.out.println(routeB.toString());
        System.out.println(K);
        Solution sol = new AmzOptimalFlightDistance().new Solution();
        List<List<Integer>> res = sol.getIdPairsOptimal(routeA, routeB, K);
        System.out.println(res.toString());
    }
    class Solution {
        public List<List<Integer>> getIdPairsOptimal(List<List<Integer>>forwardRoutes, List<List<Integer>> backwardRoutes, int maxDist) {
            List<List<Integer>> res = new LinkedList<>();

            Collections.sort(forwardRoutes, (a, b) -> Integer.compare(a.get(1), b.get(1)));
            Collections.sort(backwardRoutes, (a, b) -> Integer.compare(a.get(1), b.get(1)));
            int bestSum = 0;
            int i = 0, j = backwardRoutes.size() - 1;
            while (i < forwardRoutes.size() && j >= 0) {
                int forward = forwardRoutes.get(i).get(1);
                int backward = backwardRoutes.get(j).get(1);
                int tmpSum = forward + backward;
                if (tmpSum <= maxDist) {
                    if (tmpSum > bestSum) {
                        res = new LinkedList<List<Integer>>();
                        res.add(new ArrayList<Integer>(Arrays.asList(forwardRoutes.get(i).get(0), backwardRoutes.get(j).get(0))));
                        bestSum = tmpSum;
                    } else if (tmpSum == bestSum) {
                        res.add(new ArrayList<Integer>(Arrays.asList(forwardRoutes.get(i).get(0), backwardRoutes.get(j).get(0))));
                    }
                    i++;

                } else {
                    j--;
                }
            }

//            System.out.println(forwardRoutes.toString());
            return res;
        }

    }
}
