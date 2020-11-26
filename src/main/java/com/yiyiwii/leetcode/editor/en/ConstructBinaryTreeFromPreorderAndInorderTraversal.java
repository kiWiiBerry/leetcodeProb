//Given preorder and inorder traversal of a tree, construct the binary tree. 
//
// Note: 
//You may assume that duplicates do not exist in the tree. 
//
// For example, given 
//
// 
//preorder = [3,9,20,15,7]
//inorder = [9,3,15,20,7] 
//
// Return the following binary tree: 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics Array Tree Depth-first Search 
// 👍 4263 👎 112


package com.yiyiwii.leetcode.editor.en;

import java.util.HashMap;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(map, preorder, 0, inorder.length - 1, 0);
    }
    public TreeNode helper(HashMap<Integer, Integer> map,
                           int[] preorder,
                           int st, int end, int curr) {
        if (st > end) return null;
        int rootNum = preorder[curr];
        int index = map.get(rootNum);
        int leftLen = index - st - 1;
        TreeNode node = new TreeNode(rootNum);
        node.left = helper(map, preorder, st, index - 1, curr + 1);
        node.right = helper(map, preorder, index + 1, end, curr + 2 + leftLen);
        return node;
    }

//    // Method 1
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        if (preorder.length == 0) {
//            return null;
//        }
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < inorder.length; i++) {
//            map.put(inorder[i], i);
//        }
//        return helper(map, preorder, 0, preorder.length - 1,
//                inorder, 0, inorder.length - 1);
//    }
//    public TreeNode helper(HashMap<Integer, Integer> map,
//                           int[] preorder, int preSt, int preEnd,
//                           int[] inorder, int inSt, int inEnd) {
//        if (preSt > preEnd || inSt > inEnd) return null;
//
//        TreeNode node = new TreeNode(preorder[preSt]);
//        int index = map.get(preorder[preSt]);
//        int leftLen = index - inSt;
//        node.left = helper(map, preorder, preSt + 1, preSt + leftLen, inorder, inSt, index - 1);
//        node.right = helper(map, preorder, preSt + leftLen + 1, preEnd, inorder, index + 1, inEnd);
//        return node;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

}