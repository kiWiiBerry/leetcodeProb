//Return any binary tree that matches the given preorder and postorder traversal
//s. 
//
// Values in the traversals pre and post are distinct positive integers. 
//
// 
//
// 
// Example 1: 
//
// 
//Input: pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
//Output: [1,2,3,4,5,6,7]
// 
//
// 
//
// Note: 
//
// 
// 1 <= pre.length == post.length <= 30 
// pre[] and post[] are both permutations of 1, 2, ..., pre.length. 
// It is guaranteed an answer exists. If there exists multiple answers, you can 
//return any of them. 
// 
// 
// Related Topics Tree 
// 👍 1021 👎 55


package com.yiyiwii.leetcode.editor.en;

import java.util.HashMap;

public class ConstructBinaryTreeFromPreorderAndPostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndPostorderTraversal().new Solution();
        int[] pre = new int[]{1,2,4,5,3,6,7};
        int[] post = new int[]{4,5,2,6,7,3,1};
        TreeNode res = solution.constructFromPrePost(pre, post);
        System.out.println(res);
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
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        if (pre.length == 0) return null;
        HashMap<Integer, Integer> mapPre = new HashMap<>();
        HashMap<Integer, Integer> mapPost = new HashMap<>();

        for (int i = 0; i < post.length; i++) {
            mapPre.put(pre[i], i);
            mapPost.put(post[i], i);
        }
        return helper(pre, post, mapPre, mapPost, 0, pre.length - 1, 0, post.length - 1);
    }
    public TreeNode helper(int[] pre, int[] post,
                           HashMap<Integer, Integer> mapPre,
                           HashMap<Integer, Integer> mapPost,
                           int stPre, int endPre, int stPost, int endPost) {
        if (stPost > endPost) return null;
        if (stPost == endPost) return new TreeNode(post[stPost]);

        int leftRootPost = mapPost.get(pre[stPre + 1]);
        int rightRootPre = mapPre.get(post[endPost - 1]);

        TreeNode node = new TreeNode(pre[stPre]);

        node.left = helper(pre, post, mapPre, mapPost,
                stPre + 1, rightRootPre - 1, stPost, leftRootPost);
        node.right = helper(pre, post, mapPre, mapPost,
                rightRootPre, endPre, leftRootPost + 1, endPost - 1);

        return node;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}