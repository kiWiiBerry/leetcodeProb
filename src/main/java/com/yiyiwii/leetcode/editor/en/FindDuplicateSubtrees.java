//Given the root of a binary tree, return all duplicate subtrees. 
//
// For each kind of duplicate subtrees, you only need to return the root node of
// any one of them. 
//
// Two trees are duplicate if they have the same structure with the same node va
//lues. 
//
// 
// Example 1: 
//
// 
//Input: root = [1,2,3,4,null,2,4,null,null,4]
//Output: [[2,4],[4]]
// 
//
// Example 2: 
//
// 
//Input: root = [2,1,1]
//Output: [[1]]
// 
//
// Example 3: 
//
// 
//Input: root = [2,2,2,3,null,3,null]
//Output: [[2,3],[3]]
// 
//
// 
// Constraints: 
//
// 
// The number of the nodes in the tree will be in the range [1, 10^4] 
// -200 <= Node.val <= 200 
// 
// Related Topics Tree 
// 👍 1523 👎 216


package com.yiyiwii.leetcode.editor.en;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindDuplicateSubtrees {
    public static void main(String[] args) {
        Solution solution = new FindDuplicateSubtrees().new Solution();
        TreeNode root = new FindDuplicateSubtrees().new TreeNode(1);
        root.left = new FindDuplicateSubtrees().new TreeNode(2);
        root.left.left = new FindDuplicateSubtrees().new TreeNode(4);
        root.right = new FindDuplicateSubtrees().new TreeNode(3);
        root.right.left = new FindDuplicateSubtrees().new TreeNode(2);
        root.right.left.left = new FindDuplicateSubtrees().new TreeNode(4);
        root.right.right = new FindDuplicateSubtrees().new TreeNode(4);
        solution.findDuplicateSubtrees(root);
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
                '}';
//        ", left=" + left +
//                ", right=" + right +
    }
}

class Solution {
     public List<TreeNode> res = new ArrayList<>();
     public HashMap<Integer, Integer> cnt = new HashMap<>();
     public HashMap<String, Integer> idMap = new HashMap<>();
     public int globalID = 1;

     public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
         helper(root);
         return res;
     }
     public String helper(TreeNode node) {
         String str = "";
         if (node == null) {
             str = "NULL" + ",";
         } else {
             str = node + ",";
             str += helper(node.left);
             str += helper(node.right);
             int id = idMap.computeIfAbsent(str, x -> globalID++);
             cnt.put(id, cnt.getOrDefault(id, 0) + 1);
             if (cnt.get(id) == 2) {
                 res.add(node);
             }
         }
         return str;
     }
// Method 1
//    public List<TreeNode> res = new ArrayList<>();
//    HashMap<String, Integer> cnt = new HashMap<>();
//
//    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
//        helper(root);
//        return res;
//    }
//    public String helper(TreeNode node) {
//        String str = "";
//        if (node == null) {
//            str = "NULL" + ",";
//        } else {
//            str = node.val + ",";
//            str += helper(node.left);
//            str += helper(node.right);
//            cnt.put(str, cnt.getOrDefault(str, 0) + 1);
//            System.out.println(str.toString());
//            System.out.println(cnt.get(str));
//            if (cnt.get(str) == 2) {
//                res.add(node);
//            }
//        }
//        return str;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

}