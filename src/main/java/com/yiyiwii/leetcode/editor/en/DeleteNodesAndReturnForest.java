//Given the root of a binary tree, each node in the tree has a distinct value. 
//
// After deleting all nodes with a value in to_delete, we are left with a forest
// (a disjoint union of trees). 
//
// Return the roots of the trees in the remaining forest. You may return the res
//ult in any order. 
//
// 
// Example 1: 
//
// 
//
// 
//Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
//Output: [[1,2,null,4],[6],[7]]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the given tree is at most 1000. 
// Each node has a distinct value between 1 and 1000. 
// to_delete.length <= 1000 
// to_delete contains distinct values between 1 and 1000. 
// Related Topics Tree Depth-first Search 
// 👍 1414 👎 48


package com.yiyiwii.leetcode.editor.en;

import java.util.*;
import java.util.stream.Collectors;

public class DeleteNodesAndReturnForest {
    public static void main(String[] args) {
        Solution solution = new DeleteNodesAndReturnForest().new Solution();
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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> forest = new ArrayList<>();
        Set<Integer> set = Arrays.stream(to_delete).boxed().collect(Collectors.toSet());
        root = helper(root, set, forest);
        if (root != null) {
            forest.add(root);
        }
        return forest;
    }
    public TreeNode helper(TreeNode root, Set<Integer> set, List<TreeNode> forest) {
        if (root == null)
            return root;
        root.left = helper(root.left, set, forest);
        root.right = helper(root.right, set, forest);
        if (set.contains(root.val)) {
            if (root.left != null)
                forest.add(root.left);
            if (root.right != null)
                forest.add(root.right);
            root = null;
        }
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}