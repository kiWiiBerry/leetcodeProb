// Amazon OA, distance between two nodes in BST
// Given a list of unique integers nums, construct a BST from it (you need to
//        insert nodes one-by-one with the given order to get the BST) and find
//        the distance between two nodes node1 and node2. Distance is the number
//        of edges between two nodes. If any of the given nodes does not appear
//        in the BST, return -1.
//
//Example 1:
//
//Input: nums = [2, 1, 3], node1 = 1, node2 = 3
//Output: 2
//Explanation:
//           2
//         /   \
//        1     3

package com.yiyiwii.leetcode.editor.en;

public class AmzDistanceBinaryTree {
    public static void main(String[] args) {
        Solution solution = new AmzDistanceBinaryTree().new Solution();
        int[] nums = new int[]{5, 6, 3, 4, 8, 9};
        TreeNode root = null;
        for (int i = 0; i < nums.length; i++) {
            root = solution.insertIntoBST(nums[i], root);
        }
        TreeNode node1 = new AmzDistanceBinaryTree().new TreeNode(6);
        TreeNode node2 = new AmzDistanceBinaryTree().new TreeNode(9);
        TreeNode lca = solution.lowestCommonAncestor(root, node1, node2);
        int dist1 = solution.distanceFromRoot(lca, node1);
        int dist2 = solution.distanceFromRoot(lca, node2);
        System.out.println(root.toString());
        System.out.println(lca.val);
        System.out.println(dist1 + dist2);
    }
    /**
     * Definition for a binary tree node.
     * */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }

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
        public TreeNode insertIntoBST(int val, TreeNode root) {
            if (root == null) {
                return new TreeNode(val);
            }
            if (val < root.val) {
                root.left = insertIntoBST(val, root.left);
            } else {
                root.right = insertIntoBST(val, root.right);
            }
            return root;
        }
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (q.val > root.val && p.val > root.val) {
                return lowestCommonAncestor(root.right, p, q);
            } else if (q.val <= root.val && p.val <= root.val) {
                return lowestCommonAncestor(root.left, p, q);
            } else {
                return root;
            }
        }
        public int distanceFromRoot(TreeNode root, TreeNode q) {
            if (root.val == q.val)
                return 0;
            if (q.val > root.val) {
                return distanceFromRoot(root.right, q) + 1;
            } else {
                return distanceFromRoot(root.left, q) + 1;
            }
        }
    }
}
