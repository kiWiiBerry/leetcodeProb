//Given the root of a Binary Search Tree and a target number k, return true if t
//here exist two elements in the BST such that their sum is equal to the given tar
//get. 
//
// 
// Example 1: 
//
// 
//Input: root = [5,3,6,2,4,null,7], k = 9
//Output: true
// 
//
// Example 2: 
//
// 
//Input: root = [5,3,6,2,4,null,7], k = 28
//Output: false
// 
//
// Example 3: 
//
// 
//Input: root = [2,1,3], k = 4
//Output: true
// 
//
// Example 4: 
//
// 
//Input: root = [2,1,3], k = 1
//Output: false
// 
//
// Example 5: 
//
// 
//Input: root = [2,1,3], k = 3
//Output: true
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 104]. 
// -104 <= Node.val <= 104 
// root is guaranteed to be a valid binary search tree. 
// -105 <= k <= 105 
// 
// Related Topics Tree 
// 👍 1722 👎 146


package com.yiyiwii.leetcode.editor.en;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class TwoSumIvInputIsABst {
    public static void main(String[] args) {
        Solution solution = new TwoSumIvInputIsABst().new Solution();
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
     // Method-2
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> nums = new ArrayList<>();
        helper(root, nums);
        for (int i = 0, j = nums.size() - 1; i < j;) {
            if (nums.get(i)+ nums.get(j) == k) return true;
            if (nums.get(i)+ nums.get(j) > k) j--;
            else i++;
        }
        return false;
    }
    public void helper(TreeNode node, List<Integer> nums){
        if (node == null) return;
        helper(node.left, nums);
        nums.add(node.val);
        helper(node.right, nums);
    }
//    // Method-1
//    public boolean findTarget(TreeNode root, int k) {
//        HashSet<Integer> set = new HashSet<>();
//        return helper(root, set, k);
//    }
//    public boolean helper(TreeNode root, HashSet<Integer> set, int k) {
//        if (root == null) return false;
//        if (set.contains(k - root.val)) return true;
//        set.add(root.val);
//        return helper(root.left, set, k) || helper(root.right, set, k);
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

}