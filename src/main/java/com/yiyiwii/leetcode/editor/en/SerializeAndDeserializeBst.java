//Serialization is converting a data structure or object into a sequence of bits
// so that it can be stored in a file or memory buffer, or transmitted across a ne
//twork connection link to be reconstructed later in the same or another computer 
//environment. 
//
// Design an algorithm to serialize and deserialize a binary search tree. There 
//is no restriction on how your serialization/deserialization algorithm should wor
//k. You need to ensure that a binary search tree can be serialized to a string, a
//nd this string can be deserialized to the original tree structure. 
//
// The encoded string should be as compact as possible. 
//
// 
// Example 1: 
// Input: root = [2,1,3]
//Output: [2,1,3]
// Example 2: 
// Input: root = []
//Output: []
// 
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 104]. 
// 0 <= Node.val <= 104 
// The input tree is guaranteed to be a binary search tree. 
// 
// Related Topics String Tree Depth-First Search Breadth-First Search Design Bin
//ary Search Tree Binary Tree 
// 👍 2055 👎 98


package com.yiyiwii.leetcode.editor.en;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBst {
//    public static void main(String[] args) {
//        Codec solution = new SerializeAndDeserializeBst().new Codec();
//    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 *
 * */
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        sb = serializeHelper(root, sb);
        return sb.toString();
    }
    public StringBuilder serializeHelper(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("X").append(",");
        } else {
            sb.append(node.val).append(",");
            serializeHelper(node.left, sb);
            serializeHelper(node.right, sb);
        }
        return sb;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        Queue<String> queue = new LinkedList<>(Arrays.asList(nodes));
        TreeNode root = deserializeHelper(queue);
        return root;
    }
    public TreeNode deserializeHelper(Queue<String> queue) {
        if (queue.isEmpty()) {
            return null;
        }
        String nodeStr = queue.poll();
        if (nodeStr.equals("X")) {
             return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(nodeStr));
        node.left = deserializeHelper(queue);
        node.right = deserializeHelper(queue);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
//leetcode submit region end(Prohibit modification and deletion)

}