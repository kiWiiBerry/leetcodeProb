//
//Given a binary tree, you need to compute the length of the diameter of the tre
//e. The diameter of a binary tree is the length of the longest path between any t
//wo nodes in a tree. This path may or may not pass through the root.
// 
//
// 
//Example: 
//Given a binary tree 
// 
//          1
//         / \
//        2   3
//       / \     
//      4   5    
// 
// 
// 
//Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
// 
//
// Note:
//The length of path between two nodes is represented by the number of edges bet
//ween them.
// Related Topics Tree 
// 👍 3697 👎 220


package com.yiyiwii.leetcode.editor.en;
public class DiameterOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new DiameterOfBinaryTree().new Solution();
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
    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return diameter;
    }
    public int helper(TreeNode root) {
        if (root == null)
            return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        diameter = Math.max(left + right, diameter);
        return Math.max(left, right) + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}