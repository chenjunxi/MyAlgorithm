package com.leecode.base;

public class Day02_Link03 {
    public static void main(String[] args) {

    }

    public static class Node {

        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static class DoubleNode {

        public int value;
        public DoubleNode pre;
        public DoubleNode next;

        public DoubleNode(int data) {
            this.value = data;
        }
    }

    public static Node revernode(Node head) {
        if (head == null) return null;
        Node pre = null;
        Node cur = head;
        Node temp = null;

        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }

        return pre;

    }

    public static DoubleNode reverdouble(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next = null;


        while (head != null) {
            next = head.next;
            head.next = pre;
            head.pre = next;

            pre = head;
            head = next;

        }

        return pre;
    }
}
