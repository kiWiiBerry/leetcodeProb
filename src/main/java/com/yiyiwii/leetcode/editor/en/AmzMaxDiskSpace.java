package com.yiyiwii.leetcode.editor.en;

import java.util.*;

public class AmzMaxDiskSpace {
    public static void main(String[] args) {
        AmzMaxDiskSpace.Solution sol = new AmzMaxDiskSpace().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int availableSpace(List<Integer> freeSpace, int blockLength) {
            int res = Integer.MIN_VALUE;
            Deque<Map.Entry<Integer, Integer>> dq = new ArrayDeque<>();
            for (int i = 0; i < freeSpace.size(); i++) {
                int space = freeSpace.get(i);
                if (dq.size() > 0 && dq.getFirst().getKey() <= i - blockLength){
                    dq.pollFirst();
                }
                while (dq.size() > 0 && dq.getLast().getValue() >= space) {
                    dq.pollLast();
                }
                dq.offerLast(new AbstractMap.SimpleEntry<Integer, Integer>(i, space));
                if (i >= blockLength) {
                    res = Math.max(res, dq.getFirst().getValue());
                }
            }
            return res;
        }
    }
}
