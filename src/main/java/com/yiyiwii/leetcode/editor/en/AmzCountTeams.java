package com.yiyiwii.leetcode.editor.en;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AmzCountTeams {
    public static void main(String[] args) {
        AmzCountTeams.Solution sol = new AmzCountTeams().new Solution();

        int[] array = {4,2,5,1,6};
//        int[] res = sol.countTeams(array);
//        System.out.println(Arrays.toString(res));
    }
    class Solution {
        Map<String, Integer> map = new HashMap<>();
        public int countTeams(int num, int[] skills, int minAssociates,
                              int minLevel, int maxLevel) {
            int cnt = 0;
            for (int i = 0; i < num; i++) {
                if (skills[i] >= minLevel && skills[i] <= maxLevel){
                    cnt++;
                }
            }
            int res = 0;
            for (int i = minAssociates; i <= cnt; i++) {
                res += combine(cnt, i);
            }
            return res;
        }
        private int combine(int m, int n) {
            String key = m + "," + n;
            if (n == 0) {
                return 1;
            }
            if (n == 1) {
                return m;
            }
            if (n > m / 2) {
                return combine(m, m - n);
            }
            if (n > 1) {
                if (!map.containsKey(key)) {
                    map.put(key, combine(m - 1, n - 1) + combine(m - 1, n));
                }
                return map.get(key);
            }
            return 0;
        }
    }
}
