//You need to construct a string consists of parenthesis and integers from a bin
//ary tree with the preorder traversing way. 
//
// The null node needs to be represented by empty parenthesis pair "()". And you
// need to omit all the empty parenthesis pairs that don't affect the one-to-one m
//apping relationship between the string and the original binary tree. 
//
// Example 1: 
// 
//Input: Binary tree: [1,2,3,4]
//       1
//     /   \
//    2     3
//   /    
//  4     
//
//Output: "1(2(4))(3)"
// Explanation: Originallay it needs to be "1(2(4)())(3()())", but you need to o
//mit all the unnecessary empty parenthesis pairs. And it will be "1(2(4))(3)".
// 
// 
//
// Example 2: 
// 
//Input: Binary tree: [1,2,3,null,4]
//       1
//     /   \
//    2     3
//     \  
//      4 
//
//Output: "1(2()(4))(3)"
// Explanation: Almost the same as the first example, except we can't omit the f
//irst parenthesis pair to break the one-to-one mapping relationship between the i
//nput and the output.
// 
// Related Topics String Tree 
// 👍 835 👎 1137


package com.yiyiwii.leetcode.editor.en;
public class ConstructStringFromBinaryTree {
    public static void main(String[] args) {
        Solution solution = new ConstructStringFromBinaryTree().new Solution();
//        [1,2,3,4]
        TreeNode root = new ConstructStringFromBinaryTree().new TreeNode(1);
        root.left = new ConstructStringFromBinaryTree().new TreeNode(2);
        root.right = new ConstructStringFromBinaryTree().new TreeNode(3);
        root.left.left = new ConstructStringFromBinaryTree().new TreeNode(4);
        solution.tree2str(root);
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
    public String tree2str(TreeNode t) {
        StringBuilder sb = new StringBuilder("");
        dfs(t, sb);
        String res = sb.toString();
        return res.length() > 0 ? res.substring(1) : res;
    }
    public void dfs(TreeNode t, StringBuilder sb) {
        if (t != null) {
            sb.append("(").append(t.val);
            if (t.left != null) {
                dfs(t.left, sb);
                sb.append(")");
            }
            if (t.right != null) {
                if (t.left == null) {
                    sb.append("()");
                }
                dfs(t.right, sb);
                sb.append(")");
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}