//Given the root of a binary tree, then value v and depth d, you need to add a r
//ow of nodes with value v at the given depth d. The root node is at depth 1. 
//
// The adding rule is: given a positive integer depth d, for each NOT null tree 
//nodes N in depth d-1, create two tree nodes with value v as N's left subtree roo
//t and right subtree root. And N's original left subtree should be the left subtr
//ee of the new left subtree root, its original right subtree should be the right 
//subtree of the new right subtree root. If depth d is 1 that means there is no de
//pth d-1 at all, then create a tree node with value v as the new root of the whol
//e original tree, and the original tree is the new root's left subtree. 
//
// Example 1: 
// 
//Input: 
//A binary tree as following:
//       4
//     /   \
//    2     6
//   / \   / 
//  3   1 5   
//
//v = 1
//
//d = 2
//
//Output: 
//       4
//      / \
//     1   1
//    /     \
//   2       6
//  / \     / 
// 3   1   5   
//
// 
// 
//
//
// Example 2: 
// 
//Input: 
//A binary tree as following:
//      4
//     /   
//    2    
//   / \   
//  3   1    
//
//v = 1
//
//d = 3
//
//Output: 
//      4
//     /   
//    2
//   / \    
//  1   1
// /     \  
//3       1
// 
// 
//
// Note: 
// 
// The given d is in range [1, maximum depth of the given tree + 1]. 
// The given binary tree has at least one tree node. 
// 
// Related Topics Tree 
// 👍 839 👎 159


package com.yiyiwii.leetcode.editor.en;

import java.util.LinkedList;
import java.util.Queue;

public class AddOneRowToTree {
    public static void main(String[] args) {
        Solution solution = new AddOneRowToTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
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
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        for (int lev = 0; lev < d - 2; lev++) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);
            }
        }
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            TreeNode lnew = new TreeNode(v);
            TreeNode rnew = new TreeNode(v);
            TreeNode leftChild = curr.left;
            TreeNode rightChild = curr.right;
            curr.left = lnew;
            curr.right = rnew;
            lnew.left = leftChild;
            rnew.right = rightChild;
        }
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}