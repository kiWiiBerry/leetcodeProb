//    Transaction logs.
//
//    A Company parses logs of online store user transactions/activity to flag fraudulent activity.
//
//    The log file is represented as an Array of arrays. The arrays consist of the following data:
//
//    [ <# of transactions>]
//
//    For example:
//
//    [345366 89921 45]
//
//    Note: the data is space delimited
//
//    So, the log data would look like:
//
//    [
//    [345366 89921 45],
//    [029323 38239 23]
//    ...
//    ]
//    Write a function to parse the log data to find distinct users that meet or cross a certain threshold.
//
//    The function will take in 2 inputs:
//    logData: Log data in form an array of arrays
//
//    threshold: threshold as an integer
//
//    Output:
//    It should be an array of userids that are sorted.
//
//    If same userid appears in the transaction as userid1 and userid2, it should count as one occurrence, not two.
//
//    Example:
//    Input:
//    logData:
//
//    [
//    [345366 89921 45],
//    [029323 38239 23],
//    [38239 345366 15],
//    [029323 38239 77],
//    [345366 38239 23],
//    [029323 345366 13],
//    [38239 38239 23]
//    ...
//    ]
//    threshold: 3
//
//    Output: [345366 , 38239, 029323]
//    Explanation:
//    Given the following counts of userids, there are only 3 userids that meet or exceed the threshold of 3.
//
//    345366 -4 , 38239 -5, 029323-3, 89921-1

package com.yiyiwii.leetcode.editor.en;

import java.util.*;
import java.util.stream.Collectors;

public class AmzTransactionLogs {
    public static void main(String[] args) {
        String[] logs = {
             "345366 89921 45",
             "029323 38239 23",
             "38239 345366 15",
             "029323 38239 77",
             "345366 38239 23",
             "029323 345366 13",
             "38239 38239 23"
        };
        int K = 3;
        Solution sol = new AmzTransactionLogs().new Solution();
        List<String> res = sol.transactionLog(logs, K);
        System.out.println(Arrays.toString(logs));
        System.out.println(res.toString());
    }
    class Solution {
        public String[] processLogFile(String[] logs, int threshold) {
            Map<String, Integer> map = new HashMap<>();
            List<String> list = new ArrayList<>();
            for (String log : logs) {
                String[] words = log.split(" ");
                map.put(words[0], map.getOrDefault(words[0], 0) + 1);
                if (!words[0].equals(words[1])) {
                    map.put(words[1], map.getOrDefault(words[1], 0) + 1);
                }
            }
            for (String key : map.keySet()) {
                if (map.get(key) >= threshold) {
                    list.add(key);
                }
            }
            Collections.sort(list, (a, b) -> Integer.valueOf(b) - Integer.valueOf(a));
            String[] result = new String[list.size()];
            for (int i = 0; i < list.size(); i++) {
                result[i] = list.get(i);
            }
            return result;
        }

        public List<String> transactionLog (String[] logs, int K) {
            Map<String, Integer> map = new HashMap<>();
            for (String log : logs) {
                String[] item = log.split(" ");
                String from = item[0], to = item[1];
                map.put(from, map.getOrDefault(from, 0) + 1);
                if (!from.equals(to)) {
                    map.put(to, map.getOrDefault(to, 0) + 1);
                }
            }
            List<String> res =  map.entrySet().stream()
                    .filter(entry -> entry.getValue() >= K)
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());
            System.out.println(res.toString());

            // Natural Order: Ascending
            // Comparator.reverseOrder() :  Descending
//            Map<Long, String> resMap = new HashMap<>();
            TreeMap<Long, String> resMap = new TreeMap<>(Comparator.reverseOrder());
            for (String log : res) {
                resMap.put(Long.valueOf(log), log);
            }
            System.out.println(resMap.keySet().toString());
            return resMap.entrySet().stream()
//                    .sorted(Map.Entry.comparingByKey())
                    .map(Map.Entry::getValue)
                    .collect(Collectors.toList());
        }
    }
}
