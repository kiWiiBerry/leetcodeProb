//Find the sum of all left leaves in a given binary tree. 
//
// Example:
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//There are two left leaves in the binary tree, with values 9 and 15 respectivel
//y. Return 24.
// 
// Related Topics Tree 
// 👍 1490 👎 147


package com.yiyiwii.leetcode.editor.en;
public class SumOfLeftLeaves {
    public static void main(String[] args) {
        Solution solution = new SumOfLeftLeaves().new Solution();
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
    public int sumOfLeftLeaves(TreeNode root) {
        return helper(root, false);
    }
    public int helper(TreeNode node, boolean isLeft) {
        if (node == null) return 0;
        if (isLeft == true && node.left == null && node.right == null)
            return node.val;
        return helper(node.left, true) + helper(node.right, false);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}