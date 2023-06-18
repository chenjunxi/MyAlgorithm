package com.leecode;

public class Leecode19 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {


    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode listNode = new ListNode(-1);
        listNode.next = head;
        ListNode fast = listNode;
        ListNode slow = listNode;


        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {

            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return listNode.next;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {


        int size = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            size++;
        }

        if (size == n) {
            return head == null ? null : head.next;
        }

        int k = size - n - 1;
        cur = head;
        while (k != 0) {
            cur = cur.next;
            k--;
        }

        cur.next = cur.next.next;
        return head;
    }
}
