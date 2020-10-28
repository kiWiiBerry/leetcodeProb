//Given the root of a binary tree, return the length of the longest path, where 
//each node in the path has the same value. This path may or may not pass through 
//the root. 
//
// The length of the path between two nodes is represented by the number of edge
//s between them. 
//
// 
// Example 1: 
//
// 
//Input: root = [5,4,5,1,1,5]
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: root = [1,4,5,4,4,5]
//Output: 2
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 104]. 
// -1000 <= Node.val <= 1000 
// The depth of the tree will not exceed 1000. 
// 
// Related Topics Tree Recursion 
// 👍 1973 👎 526


package com.yiyiwii.leetcode.editor.en;
public class LongestUnivaluePath {
    public static void main(String[] args) {
        Solution solution = new LongestUnivaluePath().new Solution();
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
     int res;
     public int longestUnivaluePath(TreeNode root) {
         if (root == null) return 0;
         res = 0;
         helper(root, root.val);
         return res;
     }
     public int helper(TreeNode node, int val) {
         if (node == null) return 0;
         int l = helper(node.left, node.val);
         int r = helper(node.right, node.val);
         res = Math.max(l + r, res);
         if (node.val == val) {
             return Math.max(l, r) + 1;
         }
         return 0;
     }


//    // Method 1
//    public int longestUnivaluePath(TreeNode root) {
//        if (root == null) return 0;
//        int sub = Math.max(longestUnivaluePath(root.left), longestUnivaluePath(root.right));
//        return Math.max(sub, helper(root.left, root.val) + helper(root.right, root.val));
//    }
//    public int helper(TreeNode root, int val) {
//        if (root == null || root.val != val) return 0;
//        return 1 + Math.max(helper(root.left, val), helper(root.right, val));
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

}