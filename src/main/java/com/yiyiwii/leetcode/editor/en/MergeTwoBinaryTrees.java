//Given two binary trees and imagine that when you put one of them to cover the 
//other, some nodes of the two trees are overlapped while the others are not. 
//
// You need to merge them into a new binary tree. The merge rule is that if two 
//nodes overlap, then sum node values up as the new value of the merged node. Othe
//rwise, the NOT null node will be used as the node of new tree. 
//
// Example 1: 
//
// 
//Input: 
//	Tree 1                     Tree 2                  
//          1                         2                             
//         / \                       / \                            
//        3   2                     1   3                        
//       /                           \   \                      
//      5                             4   7                  
//Output: 
//Merged tree:
//	     3
//	    / \
//	   4   5
//	  / \   \ 
//	 5   4   7
// 
//
// 
//
// Note: The merging process must start from the root nodes of both trees. 
// Related Topics Tree 
// 👍 3614 👎 182


package com.yiyiwii.leetcode.editor.en;
public class MergeTwoBinaryTrees {
    public static void main(String[] args) {
        Solution solution = new MergeTwoBinaryTrees().new Solution();
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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}