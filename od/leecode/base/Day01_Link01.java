package com.leecode.base;

/*
 *
 * 链表删除，节点没有被引用就会被垃圾回收
 *
 * */
public class Day01_Link01 {

    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {


    }

    public static Node removeVal(Node head, int val) {
        if (head == null) return null;

        if (head.val == val) {
            head = head.next;
        }

        Node pre = head;
        Node cur = head.next;

        while (cur != null) {

            if (cur.val == val) {
                pre.next = cur.next;

            } else {
                pre = cur;
            }

            cur = cur.next;
        }

        return head;

    }
}
