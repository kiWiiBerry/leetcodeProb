package com.yiyiwii.leetcode.editor.en;

import java.util.ArrayList;

public class VisibleBinaryNode {
    public static void main(String[] args) {
        Solution solution = new VisibleBinaryNode().new Solution();
    }
    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public ArrayList<Integer> visible = new ArrayList<>();
        public int countVisibleNodes(TreeNode root) {
            return dfs(root, Integer.MIN_VALUE);
        }
        public int dfs(TreeNode root, int max) {
            if (root == null)
                return 0;
            int total = 0;
            if (root.val >= max) {
                total++;
                visible.add(root.val);
                max = Math.max(root.val, max);
            }
            total += dfs(root.left, max);
            total += dfs(root.right, max);
            return total;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}