package com.yiyiwii.leetcode.editor.en;

import java.util.LinkedList;

public class AmzFlattenLinkedList {
    Node head;
    class Node {
        int val;
        Node right, down;
        Node(int val) {
            this.val = val;
            this.right = null;
            this.down = null;
        }
    }
    public static void main(String args[])
    {
        AmzFlattenLinkedList L = new AmzFlattenLinkedList();

        /* Let us create the following linked list
            5 -> 10 -> 19 -> 28
            |    |     |     |
            V    V     V     V
            7    20    22    35
            |          |     |
            V          V     V
            8          50    40
            |                |
            V                V
            30               45
        */

        L.head = L.push(L.head, 30);
        L.head = L.push(L.head, 8);
        L.head = L.push(L.head, 7);
        L.head = L.push(L.head, 5);

        L.head.right = L.push(L.head.right, 20);
        L.head.right = L.push(L.head.right, 10);

        L.head.right.right = L.push(L.head.right.right, 50);
        L.head.right.right = L.push(L.head.right.right, 22);
        L.head.right.right = L.push(L.head.right.right, 19);

        L.head.right.right.right = L.push(L.head.right.right.right, 45);
        L.head.right.right.right = L.push(L.head.right.right.right, 40);
        L.head.right.right.right = L.push(L.head.right.right.right, 35);
        L.head.right.right.right = L.push(L.head.right.right.right, 20);

        // flatten the list
        L.head = L.flatten(L.head);

        L.printList();
    }
    Node merge(Node a, Node b) {
        if (a == null) return b;
        if (b == null) return a;

        Node res;
        if (a.val < b.val) {
            res = a;
            res.down = merge(a.down, b);
        } else {
            res = b;
            res.down = merge(a, b.down);
        }
        res.right = null;
        return res;
    }
    Node flatten(Node root) {
        if (root == null || root.right == null) {
            return root;
        }
        root.right = flatten(root.right);
        root = merge(root, root.right);
        return root;
    }

    Node push(Node head_ref, int data)
    {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(data);

        /* 3. Make next of new Node as head */
        new_node.down = head_ref;

        /* 4. Move the head to point to new Node */
        head_ref = new_node;

        /*5. return to link it back */
        return head_ref;
    }

    void printList()
    {
        Node temp = head;
        while (temp != null)
        {
            System.out.print(temp.val + " ");
            temp = temp.down;
        }
        System.out.println();
    }
}
