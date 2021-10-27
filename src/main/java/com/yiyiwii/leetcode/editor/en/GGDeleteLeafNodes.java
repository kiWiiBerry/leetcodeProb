package com.yiyiwii.leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GGDeleteLeafNodes {
    class Node {
        int val;
        Node left;
        Node right;
        Node (int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) {
        GGDeleteLeafNodes sol = new GGDeleteLeafNodes();
        Node leaf4 = sol.new Node(4);
        Node leaf5 = sol.new Node(5);
        Node leaf6 = sol.new Node(6);
        Node leaf3 = sol.new Node(3);
        Node leaf2 = sol.new Node(2);
        Node leaf1 = sol.new Node(1);

        Node leaf7 = sol.new Node(7);

        leaf2.left = leaf4;
        leaf3.left = leaf5;
        leaf3.right = leaf6;

        leaf4.left = leaf7;


        leaf1.left = leaf2;
        leaf1.right = leaf3;
        List<List<Integer>> res = sol.deleteLeaf(leaf1);
        sol.printResults(res);
    }
    public void printResults(List<List<Integer>> res) {
        for (List<Integer> list : res) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
    public List<List<Integer>> deleteLeaf (Node root) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if (root == null) return res;

        while (root.left != null || root.right != null) {
            helper(root, list);
            res.add(list);
            list = new ArrayList<>();
        }
        return res;
    }

    public Node helper(Node root, List<Integer> list) {
        if (root == null) return null;
        if (root.left == null && root.right == null) {
            list.add(root.val);
            return null;
        }
        root.left = helper(root.left, list);
        root.right = helper(root.right, list);
        return root;
    }
}
