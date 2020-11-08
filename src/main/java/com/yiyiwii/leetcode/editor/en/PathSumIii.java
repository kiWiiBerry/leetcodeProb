//You are given a binary tree in which each node contains an integer value. 
//
// Find the number of paths that sum to a given value. 
//
// The path does not need to start or end at the root or a leaf, but it must go 
//downwards
//(traveling only from parent nodes to child nodes). 
//
// The tree has no more than 1,000 nodes and the values are in the range -1,000,
//000 to 1,000,000.
//
// Example:
// 
//root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
//
//      10
//     /  \
//    5   -3
//   / \    \
//  3   2   11
// / \   \
//3  -2   1
//
//Return 3. The paths that sum to 8 are:
//
//1.  5 -> 3
//2.  5 -> 2 -> 1
//3. -3 -> 11
// 
// Related Topics Tree 
// 👍 4373 👎 309


package com.yiyiwii.leetcode.editor.en;
public class PathSumIii {
    public static void main(String[] args) {
        Solution solution = new PathSumIii().new Solution();
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
    public int pathSum(TreeNode root, int sum) {
        if (root == null)
            return 0;

        return pathSum(root.left, sum) + pathSum(root.right, sum) +
                helper(root, sum);
    }
    public int helper(TreeNode root, int sum) {
        if (root == null)
            return 0;
        int count = (root.val == sum) ? 1 : 0;
        count += helper(root.left, sum - root.val);
        count += helper(root.right, sum - root.val);
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}