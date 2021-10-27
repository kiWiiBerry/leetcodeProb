package com.yiyiwii.leetcode.editor.en;

public class GGSumOfLeavesBinaryTree {
    class Node {
        int val;
        Node left;
        Node right;
        Node(int val) {
            this.val = val;
        }
    }
    ///                1
    ///          2            3
    ///      4      5       6     7
    ///   _     8  9  10  _   11         (8+9+10+11+7 = 45)
    public static void main(String[] args) {
        GGSumOfLeavesBinaryTree sol = new GGSumOfLeavesBinaryTree() ;
        Node root = sol.new Node(1);
        Node n2 = sol.new Node(2);
        Node n3 = sol.new Node(3);
        Node n4 = sol.new Node(4);
        Node n5 = sol.new Node(5);
        Node n6 = sol.new Node(6);
        Node n7 = sol.new Node(7);
        Node n8 = sol.new Node(8);
        Node n9 = sol.new Node(9);
        Node n10 = sol.new Node(10);
        Node n11 = sol.new Node(11);
        Node n12 = sol.new Node(12);
        root.left = n2; root.right = n3;
        n2.left = n4; n2.right = n5;
        n3.left = n6; n3.right = n7;
        n4.right = n8;
        n5.left = n9; n5.right = n10;
        n6.right = n11;
        n7.right = n12;

        int res = sol.sumOfLeaves(root);
        System.out.println("res: " + res);
    }

    public int sumOfLeaves(Node node){
        if (node == null) return 0;

        int sum = 0;
        sum += sumOfLeaves(node.left);
        if (node.left == null && node.right == null) {
            return node.val;
        }
        sum += sumOfLeaves(node.right);

        return sum;
    }

    public int sumOfLeavesLessSpace(Node node) {
//        Node curr, prev;
//        if (node == null) return 0;
//        curr = node;
//        while (curr != null) {
//            if (curr.left == null) {
//                curr = curr.right;
//            } else {
//                prev = curr.left;
//                while (prev.right )
//            }
//        }
        return 0;
    }
}