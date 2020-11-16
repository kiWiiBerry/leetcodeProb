//We are given the head node root of a binary tree, where additionally every nod
//e's value is either a 0 or a 1. 
//
// Return the same tree where every subtree (of the given tree) not containing a
// 1 has been removed. 
//
// (Recall that the subtree of a node X is X, plus every node that is a descenda
//nt of X.) 
//
// 
//Example 1:
//Input: [1,null,0,0,1]
//Output: [1,null,0,null,1]
// 
//Explanation: 
//Only the red nodes satisfy the property "every subtree not containing a 1".
//The diagram on the right represents the answer.
//
//
// 
//
// 
//Example 2:
//Input: [1,0,1,0,0,0,1]
//Output: [1,null,1,null,1]
//
//
//
// 
//
// 
//Example 3:
//Input: [1,1,0,1,1,0,1,0]
//Output: [1,1,0,1,1,null,1]
//
//
//
// 
//
// Note: 
//
// 
// The binary tree will have at most 200 nodes. 
// The value of each node will only be 0 or 1. 
// 
// Related Topics Tree 
// 👍 1218 👎 50


package com.yiyiwii.leetcode.editor.en;
public class BinaryTreePruning {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePruning().new Solution();
        TreeNode root = new BinaryTreePruning().new TreeNode(1);
        root.right = new BinaryTreePruning().new TreeNode(0);
        root.right.left = new BinaryTreePruning().new TreeNode(0);
        root.right.right = new BinaryTreePruning().new TreeNode(1);

        TreeNode res = solution.pruneTree(root);
        System.out.println(res.toString());
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

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}

class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null)
            return null;
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.left == null && root.right == null && root.val == 0) {
            return null;
        }
//        if (root.left != null && root.left.val == 0) {
//            root.left = pruneTree(root.left);
//        }
//        if (root.right != null && root.right.val == 0) {
//            root.right = pruneTree(root.right);
//        }
        return root;
    }
    public TreeNode helper(TreeNode node) {
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}