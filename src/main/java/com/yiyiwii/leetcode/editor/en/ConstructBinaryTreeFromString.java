
package com.yiyiwii.leetcode.editor.en;
public class ConstructBinaryTreeFromBinaryTree {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromBinaryTree().new Solution();
//        [1,2,3,4]
        TreeNode root = new ConstructBinaryTreeFromBinaryTree().new TreeNode(1);
        root.left = new ConstructBinaryTreeFromBinaryTree().new TreeNode(2);
        root.right = new ConstructBinaryTreeFromBinaryTree().new TreeNode(3);
        root.left.left = new ConstructBinaryTreeFromBinaryTree().new TreeNode(4);
        solution.str2tree(root);
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
        public String str2tree(TreeNode t) {
            StringBuilder sb = new StringBuilder("");
            dfs(t, sb);
            String res = sb.toString();
            return res.length() > 0 ? res.substring(1) : res;
        }
        public void dfs(TreeNode t, StringBuilder sb) {

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
