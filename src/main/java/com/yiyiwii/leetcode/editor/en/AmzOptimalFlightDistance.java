package com.yiyiwii.leetcode.editor.en;

import java.util.*;
import java.util.stream.Collectors;

public class AmzOptimalFlightDistance {
    public static void main(String[] args) {
//        List<List<Integer>> routeA = Arrays.asList(Arrays.asList(1, 3000), Arrays.asList(2, 5000), Arrays.asList(3, 7000), Arrays.asList(4, 10000), Arrays.asList(5, 5000));
//        List<List<Integer>> routeB = Arrays.asList(Arrays.asList(1, 3000), Arrays.asList(2, 9000), Arrays.asList(3, 5000));
//        int K = 10000;
//        List<List<Integer>> routeA = Arrays.asList(Arrays.asList(1, 9), Arrays.asList(2, 9), Arrays.asList(3, 9), Arrays.asList(4, 9));
//        List<List<Integer>> routeB = Arrays.asList(Arrays.asList(1, 11), Arrays.asList(2, 11), Arrays.asList(3, 11));
//        int K = 30;
//        System.out.println(routeA.toString());
//        System.out.println(routeB.toString());
//        System.out.println(K);
        Solution sol = new AmzOptimalFlightDistance().new Solution();
        sol.test(Arrays.asList(Arrays.asList(1, 2), Arrays.asList(2, 3), Arrays.asList(3, 6), Arrays.asList(4, 2), Arrays.asList(5, 4), Arrays.asList(6, 4), Arrays.asList(7,7), Arrays.asList(8,9), Arrays.asList(9, 1), Arrays.asList(10,12)),
                Arrays.asList(Arrays.asList(1, 6), Arrays.asList(2, 6), Arrays.asList(3, 11), Arrays.asList(6, 3), Arrays.asList(4, 11), Arrays.asList(5,4), Arrays.asList(7,7), Arrays.asList(9,6),Arrays.asList(10,8),Arrays.asList(8, 10)),
                12,
                new ArrayList<List<Integer>>(new ArrayList<>()));
        sol.test(Arrays.asList(Arrays.asList(1,8), Arrays.asList(2,15), Arrays.asList(3, 9)),
                Arrays.asList(Arrays.asList(1,8), Arrays.asList(2,11), Arrays.asList(3, 12)),
                20,
                new ArrayList<List<Integer>>(new ArrayList<>()));
//        sol.test(Arrays.asList(Arrays.asList(1, 9), Arrays.asList(2, 9), Arrays.asList(3, 9), Arrays.asList(4, 9)), Arrays.asList(Arrays.asList(1, 11), Arrays.asList(2, 11), Arrays.asList(3, 11));)
//        List<List<Integer>> res = sol.getIdPairsOptimal(routeA, routeB, K);

//        System.out.println(res.toString());
    }
    class Solution {
        public void test(List<List<Integer>>forwardRoutes, List<List<Integer>> backwardRoutes, int maxDist, List<List<Integer>> expected) {
            List<List<Integer>> result = getIdPairsOptimal(forwardRoutes,  backwardRoutes, maxDist);
            System.out.println("ACTUAL: " + Arrays.toString(result.toArray()));
            System.out.println("EXPECTED: " + Arrays.toString(expected.toArray()));
        }
        public List<List<Integer>> getIdPairsOptimal(List<List<Integer>>forwardRoutes, List<List<Integer>> backwardRoutes, int maxDist) {
            List<List<Integer>> res = new LinkedList<>();
            int lenForward = forwardRoutes.size();
            int lenBack = backwardRoutes.size();
            forwardRoutes.sort((a,b) -> b.get(1) - a.get(1));
            backwardRoutes.sort((a,b) -> a.get(1) - b.get(1));

            System.out.println(Arrays.toString(forwardRoutes.toArray()));
            System.out.println(Arrays.toString(backwardRoutes.toArray()));

            Map<List<Integer>, Integer> map = new HashMap<>();
            for (int i = 0; i < lenForward; i++) {
                for (int j = 0; j < lenBack; j++) {
                    int forward = forwardRoutes.get(i).get(1);
                    int back = backwardRoutes.get(j).get(1);
                    if (forward + back <= maxDist) {
                        List<Integer> ids = new ArrayList<>(Arrays.asList(forwardRoutes.get(i).get(0), backwardRoutes.get(j).get(0)));
                        map.put(ids, forward + back);
                    } else {
                        break;
                    }
                }
            }

            List<Map.Entry<List<Integer>, Integer>> list = new ArrayList<>(map.entrySet());
            list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
            System.out.println(Arrays.toString(list.toArray()));

            int maxSum = list.get(0).getValue();
            for (int i = 0; i < list.size() && list.get(i).getValue() == maxSum; i++) {
                res.add(list.get(i).getKey());
            }

            if (list.size() == 0) {
                res.add(new ArrayList<>());
            }
            return res;
        }

    }
}
