//
//Given a binary tree, find the leftmost value in the last row of the tree. 
// 
//
// Example 1: 
// 
//Input:
//
//    2
//   / \
//  1   3
//
//Output:
//1
// 
// 
//
// Example 2: 
// 
//Input:
//
//        1
//       / \
//      2   3
//     /   / \
//    4   5   6
//       /
//      7
//
//Output:
//7
// 
// 
//
// Note:
//You may assume the tree (i.e., the given root node) is not NULL.
// Related Topics Tree Depth-first Search Breadth-first Search 
// 👍 1142 👎 157


package com.yiyiwii.leetcode.editor.en;

import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftTreeValue {
    public static void main(String[] args) {
//        Solution solution = new FindBottomLeftTreeValue().new Solution();
//        TreeNode root = new FindBottomLeftTreeValue().new TreeNode(2);
//        root.left = new FindBottomLeftTreeValue().new TreeNode(1);
//        root.right = new FindBottomLeftTreeValue().new TreeNode(3);
//        int res = solution.findBottomLeftValue(root);
//        System.out.println("bottom left: " + res);
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
     // Method-2, DFS
     public int findBottomLeftValue(TreeNode root) {
         return helper(root, 1, new int[]{0, 0});
     }
     public int helper(TreeNode node, int depth, int[] res) {
         if (res[1] < depth) {
             res[0] = node.val;
             res[1] += 1;
         }
         if (node.left != null) {
             helper(node.left, depth + 1, res);
         }
         if (node.right != null) {
             helper(node.right, depth + 1, res);
         }
         return res[0];
     }
//    // Method-1 BFS
//    public int findBottomLeftValue(TreeNode root) {
//        Queue<TreeNode> q = new LinkedList<>();
//        if (root == null) return 0;
//        q.add(root);
//        while (!q.isEmpty()) {
//            boolean bot = true;
//
//            int size = q.size();
//            for (int i = size - 1; i >= 0; i--) {
//                TreeNode curr = q.remove();
//
//                if (curr.right != null) {
//                    bot = false;
//                    q.add(curr.right);
//                }
//                if (curr.left != null) {
//                    bot = false;
//                    q.add(curr.left);
//                }
//
//                if (bot && i == 0) {
//                    return curr.val;
//                }
//            }
//        }
//        return 0;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

}