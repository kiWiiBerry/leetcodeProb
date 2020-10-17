
package com.yiyiwii.leetcode.editor.en;

import java.util.Stack;

public class ConstructBinaryTreeFromString {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromString().new Solution();
//        [1,2,3,4]
//        TreeNode root = new ConstructBinaryTreeFromString().new TreeNode(1);
//        root.left = new ConstructBinaryTreeFromString().new TreeNode(2);
//        root.right = new ConstructBinaryTreeFromString().new TreeNode(3);
//        root.left.left = new ConstructBinaryTreeFromString().new TreeNode(4);
        String str = "-4(2(3)(1))(6(5))";
        solution.str2tree(str);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for a binary tree node.
     * */
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
        public TreeNode str2tree(String s) {
            if (s == null || s.isEmpty())
                return null;
            Stack<TreeNode> stack = new Stack();
            for (int i = 0; i < s.length(); i++) {
                char curr = s.charAt(i);
                if (curr == ')') {
                    stack.pop();
                } else if (Character.isDigit(curr) || curr == '-') {
                    int j = i;
                    while (i < s.length() - 1 && Character.isDigit(s.charAt(i + 1)))
                        i++;
                    TreeNode node = new TreeNode(Integer.parseInt(s.substring(j, i + 1)));
                    if (!stack.isEmpty()) {
                        TreeNode root = stack.peek();
                        if (root.left == null) root.left = node;
                        else root.right = node;
                    }
                    stack.push(node);
                }
            }
            return stack.peek();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
