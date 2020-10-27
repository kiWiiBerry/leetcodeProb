//Given a binary tree, return all root-to-leaf paths. 
//
// Note: A leaf is a node with no children. 
//
// Example: 
//
// 
//Input:
//
//   1
// /   \
//2     3
// \
//  5
//
//Output: ["1->2->5", "1->3"]
//
//Explanation: All root-to-leaf paths are: 1->2->5, 1->3
// Related Topics Tree Depth-first Search 
// 👍 2076 👎 117


package com.yiyiwii.leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePaths().new Solution();
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
     // Method 2: use StringBuilder
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfs(root, new StringBuilder(""), res);
        return res;
    }
    public void dfs(TreeNode root, StringBuilder sb, List<String> res) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            sb.append(root.val);
            res.add(sb.toString());
            return;
        }
        sb.append(root.val).append("->");
        int tmpLen = sb.length();

        dfs(root.left, sb, res);
        sb.setLength(tmpLen);
        dfs(root.right, sb, res);
        sb.setLength(tmpLen);
    }
//    //Method 1: use String
//    public List<String> binaryTreePaths(TreeNode root) {
//        List<String> res = new ArrayList<>();
//        dfs(root, "", res);
//        return res;
//    }
//    public void dfs(TreeNode root, String path, List<String> res) {
//        if (root == null) return;
//        if (root.left == null && root.right == null)
//            res.add(path + root.val);
//        dfs(root.left, path + root.val + "->", res);
//        dfs(root.right, path + root.val + "->", res);
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

}