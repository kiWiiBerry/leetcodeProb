//Given a binary tree and a sum, find all root-to-leaf paths where each path's s
//um equals the given sum. 
//
// Note: A leaf is a node with no children. 
//
// Example: 
//
// Given the below binary tree and sum = 22, 
//
// 
//      5
//     / \
//    4   8
//   /   / \
//  11  13  4
// /  \    / \
//7    2  5   1
// 
//
// Return: 
//
// 
//[
//   [5,4,11,2],
//   [5,8,4,5]
//]
// 
// Related Topics Tree Depth-first Search 
// 👍 2197 👎 78


package com.yiyiwii.leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

public class PathSumIi {
    public static void main(String[] args) {
        Solution solution = new PathSumIi().new Solution();
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, sum, new ArrayList<Integer>(), res);
        return res;
    }
    public void dfs(TreeNode root, int sum,
                    List<Integer> list, List<List<Integer>> res) {
        if (root == null) return;
        list.add(root.val);
        if (root.left == null && root.right == null && sum == root.val) {
            res.add(new ArrayList(list));
            list.remove(list.size() - 1);
            return;
        }
        dfs(root.left, sum - root.val, list, res);
        dfs(root.right, sum - root.val, list, res);
        list.remove(list.size() - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}