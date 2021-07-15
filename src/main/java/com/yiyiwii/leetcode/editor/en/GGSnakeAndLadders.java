package com.yiyiwii.leetcode.editor.en;

import java.util.LinkedList;
import java.util.Queue;

public class GGSnakeAndLadders {
    public static void main(String[] args) {
        GGSnakeAndLadders.Solution solution = new GGSnakeAndLadders().new Solution();

        int[] board = {0, 0, 3, 0, -1};
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int GGSnakeAndLadders(int[] board) {
            int len = board.length;
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(0);
            boolean[] visited = new boolean[len];

            int res = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int curr = queue.poll();
                    if (visited[curr]) {
                        continue;
                    }
                    visited[curr] = true;

                    if (curr == len - 1) return res;

                    for (int k = 1; k <= 6 && curr + k < len; k++) {
                        int next = curr + k;
                        int value = board[next];
                        if (value != 0) {
                            int nextStep = next + value;
                            if (nextStep >= 0 && nextStep < len) {
                                queue.offer(nextStep);
                            }
                        }
                        queue.offer(next);
                    }
                }
                res++;
            }
            return -1;
        }
    }
}
