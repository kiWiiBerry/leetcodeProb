//Serialization is the process of converting a data structure or object into a s
//equence of bits so that it can be stored in a file or memory buffer, or transmit
//ted across a network connection link to be reconstructed later in the same or an
//other computer environment. 
//
// Design an algorithm to serialize and deserialize a binary tree. There is no r
//estriction on how your serialization/deserialization algorithm should work. You 
//just need to ensure that a binary tree can be serialized to a string and this st
//ring can be deserialized to the original tree structure. 
//
// Example: 
//
// 
//You may serialize the following tree:
//
//    1
//   / \
//  2   3
//     / \
//    4   5
//
//as "[1,2,3,null,null,4,5]"
// 
//
// Clarification: The above format is the same as how LeetCode serializes a bina
//ry tree. You do not necessarily need to follow this format, so please be creativ
//e and come up with different approaches yourself. 
//
// Note: Do not use class member/global/static variables to store states. Your s
//erialize and deserialize algorithms should be stateless. 
// Related Topics Tree Design 
// 👍 3169 👎 153

  
package com.yiyiwii.leetcode.editor.en;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {
    public static void main(String[] args) {
//        Solution solution = new SerializeAndDeserializeBinaryTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//public class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//    TreeNode(int x) { val = x; }
//}

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    public void serializeHelper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null").append(",");
        } else {
            sb.append(root.val).append(",");
            serializeHelper(root.left, sb);
            serializeHelper(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(",")));
        return deserializeHelper(nodes);

    }
    public TreeNode deserializeHelper(Queue<String> nodes) {
        String val = nodes.remove();
        if (val.equals("null")) {
            return null;
        } else {
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = deserializeHelper(nodes);
            node.right = deserializeHelper(nodes);
            return node;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)

}