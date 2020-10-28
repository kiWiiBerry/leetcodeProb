//Given a non-empty binary tree, find the maximum path sum. 
//
// For this problem, a path is defined as any node sequence from some starting n
//ode to any node in the tree along the parent-child connections. The path must co
//ntain at least one node and does not need to go through the root. 
//
// 
// Example 1: 
//
// 
//Input: root = [1,2,3]
//Output: 6
// 
//
// Example 2: 
//
// 
//Input: root = [-10,9,20,null,null,15,7]
//Output: 42
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 3 * 104]. 
// -1000 <= Node.val <= 1000 
// 
// Related Topics Tree Depth-first Search 
// 👍 4528 👎 333


package com.yiyiwii.leetcode.editor.en;
public class BinaryTreeMaximumPathSum {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeMaximumPathSum().new Solution();
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
    public int maxPathSum(TreeNode root) {
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}